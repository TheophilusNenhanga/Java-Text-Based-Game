package Game;

import Actions.Action;
import Files.FileReader;
import Player.Player;
import World.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Scanner scanner;
    public static World world;


    public Game(){
        this.scanner = new Scanner(System.in);
        world = new World();
    }

    public void playerStory(){
        FileReader fileReader = new FileReader("Files/playerStory.txt");
        fileReader.printContents();
        System.out.println("\nWhat would you like to do\n");
    }

    public void leaderboard(){
        FileReader fileReader = new FileReader("Files/leaderboard.txt");
        fileReader.printContents();
        System.out.println("\nWhat would you like to do\n");
    }

    public void credits(){
        FileReader fileReader = new FileReader("Files/credits.txt");
        fileReader.printContents();
        System.out.println("\nWhat would you like to do\n");
    }

    public void exitGame(){
        System.out.println("\nGoodbye\n");
        System.exit(0);
    }
    public void exitScreen(){
        System.out.println("---------CAVER---------\n");
        System.out.println("Thank you for playing the game.");
        System.out.println("""
                1. Read the story
                2. Leaderboard
                3. Credits
                4. Quit Game
                """);

        while (true){
            String choice = "";
            System.out.println("\nWhat would you like to do");
            // TODO: Add error checking for input types.
            try{
                choice = this.scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Incorrect input type");
                // exitScreen();
            }

            switch (choice){
                case "1" -> {
                    this.playerStory();
                    exitScreen();
                }
                case "2" -> {this.leaderboard();}
                case "3" -> {this.credits();}
                case "4" -> {this.exitGame();}
                default -> System.out.println("Incorrect Input");
            }
        }
    }

    public void startScreen(){
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
            try {
                choice = this.scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Incorrect input type");
            }

            switch (choice){
                case "1" -> {this.playGame();}
                case "2" -> {this.playerStory();}
                case "3" -> {this.leaderboard();}
                case "4" -> {this.credits();}
                case "5" -> {this.exitGame();}
                default -> System.out.println("Incorrect Input");
            }

        }
    }

    public void playGame() {
        System.out.println("-----CAVER-----\n");

        world.parseWorld();
        int[] startLocation = world.startLocation;
        Player player = new Player(startLocation[0], startLocation[1]);

        while(player.isAlive() && !player.victory){
            MapTile room = world.getTile(player.x, player.y);
            room.introText();

            room.modifyPlayer(player);
            if (player.isAlive() && !player.victory){
                chooseAction(room, player);
            }else if (!player.isAlive()) {
                System.out.println("""
                        Your journey has come to an early end.
                                ---GAME OVER---
                        """);
                end(player);
            } else if (player.isAlive() && player.victory) {
                end(player);
            }
        }
    }

    public void chooseAction(MapTile room, Player player){
        // TODO: Add implementation from python source (This is the reason nothing happens on the starting tile.)
        Action action = null;

        while (action == null){
            ArrayList<Action> availableActions = new ArrayList<>();
            availableActions = this.getAvailableActions(room, player);
            String actionInput = scanner.nextLine();
            for (Action act: availableActions){
                if(act.hotkey.equals(actionInput) || act.name.equals(actionInput) ){
                    System.out.println(act.name);
                }
            }
        }
    }

    public void end(Player player){
        // TODO: Add implementation. end(Player player)
        // How to clear the console: https://stackoverflow.com/questions/2979383/how-to-clear-the-console
        System.out.println("\n You will now be taken to the exit screen \n");

    }

    public ArrayList<Action> getAvailableActions(MapTile room, Player player){
        ArrayList<Action> actions = new ArrayList<Action>();
        System.out.println("\nChoose an Action:");
        if (player != null){
            Action action = new Action.details();
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }
        if (player.inventory != null){
            Action action = new Action.inventory();
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        if (world.getTile(room.x,room.y - 1 ) != null){
            Action action = new Action.north();
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        if (world.getTile(room.x,room.y + 1 ) != null){
            Action action = new Action.south();
            actions.add(action);
            System.out.println(action.hotkey + ": " + action.name);
        }

        return actions;
    }

}
