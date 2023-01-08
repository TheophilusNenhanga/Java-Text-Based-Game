package World;

import Enemies.Enemies;
import Player.Player;

import java.util.Objects;
import java.util.Random;

public abstract class MapTile {

    public int x;
    public int y;
    boolean completed;
    public Enemies enemy;

    Random random;

    public MapTile(int x, int y){
        this.x = x;
        this.y = y;
        this.completed = false;
        this.random = new Random();
        this.enemy = null;
    }

    public void introText(){

    }

    public void modifyPlayer(Player player){

    }

    public void converse(){

    }

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
