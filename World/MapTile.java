package World;

import Player.Player;

import java.util.Objects;
import java.util.Random;

public abstract class MapTile {

    int x;
    int y;
    boolean completed;

    Random random;

    public MapTile(int x, int y){
        this.x = x;
        this.y = y;
        this.completed = false;
        this.random = new Random();
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
