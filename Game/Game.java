package Game;

import Files.FileReader;
import Player.Player;
import World.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
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
            MapTile room = world.GetTile(player.x, player.y);
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
        // TODO: Add implementation
    }

    public void end(Player player){
        // TODO: Add implementation.
    }



}
