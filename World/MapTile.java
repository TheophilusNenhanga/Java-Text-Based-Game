package World;

import Enemy.Enemy;
import Player.Player;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public abstract class MapTile {

    public int x;
    public int y;
    public boolean completed = false;
    public Enemy enemy;

    public static Random random = new Random();

    public static Scanner scanner = new Scanner(System.in);

    public MapTile(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void modifyPlayer(Player player){

    }

    public void introText(){

    }
    public void converse(){

    }

    // TODO: Test that this method works correctly. Looking for key words
    public boolean lookingForKeyWords(String userInput, String searchString){
        String[] split = userInput.split(" ");
        for (String word : split){
            if (Objects.equals(word, searchString)){
                return true;
            }
        }
        return false;
    }



}
