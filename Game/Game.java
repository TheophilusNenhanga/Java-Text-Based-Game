package Game;

import Action.Action;
import Files.FileRead;
import Leaderboard.LeaderLoader;
import Files.MakeFiles;
import Files.MapLoader;
import Player.Player;
import World.*;
import World.EnemyTiles.EnemyTile;
import World.NPCTiles.ArmourSmithTile;
import World.NPCTiles.EnchanterTile;
import World.NPCTiles.TraderTile;
import World.NPCTiles.WeaponSmithTile;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Scanner scanner;
    public static World world;

    public Game(){
        this.scanner = new Scanner(System.in);
    }

    public static World initializeWorld(int mapIndex, MapLoader mapLoader){
        return new World(mapIndex, mapLoader);
    }

    private void chooseMap(){
        MapLoader mapLoader = new MapLoader();
        int numberOfMaps = mapLoader.mapNumber();

        int chosenInteger = -1;
        int j = 0;
        while (j < 5) {
            j += 1;
            System.out.println("---Choose a World---\n");
            for (int i = 0; i < numberOfMaps; i++) {
                System.out.printf("%d. %s\n", i+1, mapLoader.mapNames.get(i));
            }

            String chosenString = this.scanner.nextLine();
            try {
                chosenInteger = Integer.parseInt(chosenString);
                if (numberOfMaps < chosenInteger){
                    throw new RuntimeException();
                }
                break;
            }catch (RuntimeException ignored){
                System.out.println("Incorrect value entered");
            }

        }
        if (chosenInteger == -1){
            world = initializeWorld(1, mapLoader);
        }else{
            world = initializeWorld(chosenInteger, mapLoader);
        }

    }

    public void playerStory(){
        FileRead fileRead = new FileRead("Files/playerStory.txt");
        if (!fileRead.isEmpty()){
            fileRead.printContents();
        }else{
            System.out.println("Error: Failed to print player story");
        }
    }

    public void leaderboard(){
        // TODO: Read from properties file 2023/04/12
        LeaderLoader leaderLoader = new LeaderLoader();
        if (leaderLoader.isEmpty()){
            System.out.println("""
                    -----NOT A SINGLE SOUL HAS MADE IT TO THE LEADERBOARD-----
                                    -----BE THE FIRST-----
                    """);
        }else {
            for (int i = 0; i <= leaderLoader.getLeaderNumber()-1; i++) {
                System.out.println(leaderLoader.getLeader(i));
            }
        }
    }

    public void credits(){
        FileRead fileRead = new FileRead("Files/credits.txt");
        if (!fileRead.isEmpty()) {
            fileRead.printContents();
        }else{
            System.out.println("Error: Failed to print credits.");
        }
    }

    public void exitGame(){
        System.out.println("\nGoodbye\n");
        System.exit(0);
    }
    public void exitScreen(){
        System.out.println("---------CAVER---------\n");
        System.out.println("Thank you for playing the game.");
        System.out.println("""
                1. Play Again
                2. Read the story
                3. Leaderboard
                4. Credits
                5. Quit Game
                """);

        while (true){
            String choice = "";
            System.out.println("\nWhat would you like to do");
            // TODO: Add error checking for input types.
            choiceMenu(choice);
        }
    }

    private void choiceMenu(String choice) {
        try{
            choice = this.scanner.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Incorrect input type");
            // exitScreen();
        }

        switch (choice){
            case "1" -> this.playGame();
            case "2" -> this.playerStory();
            case "3" -> this.leaderboard();
            case "4" -> this.credits();
            case "5" -> this.exitGame();
            default -> System.out.println("Incorrect Input");
        }
    }

    public void startScreen(){
        MakeFiles.createLeaderboard();

        System.out.println("---------CAVER---------");
        System.out.println("Welcome to the game.");
        System.out.println("""
                1. Play Caver
                2. Read The Story
                3. Leaderboard
                4. Credits
                5. Quit Game
                                
                If it is your first time playing the game.
                Reading the story is recommended.
                This will give you a background of the game.
                                
                Hope you enjoy!
                """);
        System.out.println("What would you like to do");

        while (true){
            String choice = "";
            choiceMenu(choice);
            System.out.println("\nWhat would you like to do?\n");
        }
    }

    public void playGame() {
        System.out.println("-----CAVER-----\n");

        this.chooseMap();

        world.parseWorld();
        int[] startLocation = world.startLocation;
        Player player = new Player(startLocation[0], startLocation[1]);

        while(player.isAlive() && !player.victory){
            MapTile room = world.getTile(player.x, player.y);
            room.introText();
            room.modifyPlayer(player);

            if (player.victory && player.isAlive()){
                end(player);
            }else if (player.isAlive() && !player.victory){
                chooseAction(room, player);
            }else if (!player.isAlive()) {
                System.out.println("""
                        Your journey has come to an early end.
                                ---GAME OVER---
                        """);
                end(player);
            }
        }
    }

    public void chooseAction(MapTile room, Player player){
        ArrayList<Action> availableActions;
        availableActions = this.getAvailableActions(room, player);
        String actionInput = scanner.nextLine();
        for (Action act: availableActions){
            if(act.hotkey.equals(actionInput) || act.name.equals(actionInput) ){
                act.actionPerformed();
            }
        }
    }


    public void end(Player player){
        if (!player.hasName()) {
            System.out.println("Enter your name: \n");
            String name = this.scanner.nextLine();
            if (name.equals("")){
                end(player);
            }
            player.name = name;
        }
        try {
            LeaderLoader leaderLoader = new LeaderLoader();
            leaderLoader.addLeader(player.name, player.score);

        } catch (RuntimeException e){
            System.out.println("Error: Failed to write to file");
        }

        System.out.println("\n You will now be taken to the exit screen \n");
        exitScreen();
    }

    public ArrayList<Action> getAvailableActions(MapTile room, Player player){
        ArrayList<Action> actions = new ArrayList<>();
        System.out.println("\nChoose an Action:");
        if (player != null){
            Action action = new Action.details(player);
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        if (player.inventory != null){
            Action action = new Action.inventory(player);
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        if (player.hp < 100){
            Action action = new Action.heal(player);
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        if (world.getTile(room.x,room.y - 1 ) != null){
            Action action = new Action.north(player);
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        if (world.getTile(room.x,room.y + 1 ) != null){
            Action action = new Action.south(player);
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        if (world.getTile(room.x+1,room.y) != null){
            Action action = new Action.east(player);
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        if (world.getTile(room.x-1,room.y) != null){
            Action action = new Action.west(player);
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        if (world.getTile(room.x, room.y) instanceof EnemyTile && !room.completed){
            Action action = new Action.attack(player, room);
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        if (world.getTile(room.x, room.y) instanceof TraderTile){
            Action action = new Action.trade(player);
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        if (world.getTile(room.x, room.y) instanceof WeaponSmithTile){
            Action action = new Action.tradeWeapon(player);
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        if (world.getTile(room.x, room.y) instanceof ArmourSmithTile){
            Action action = new Action.tradeArmour(player);
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        if (world.getTile(room.x, room.y) instanceof EnchanterTile){
            Action action = new Action.enchant(player);
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        return actions;
    }

}
