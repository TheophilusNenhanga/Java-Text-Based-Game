package World.CorridorTiles;

import Player.Player;
import World.MapTile;

public class CorridorTile extends MapTile {

    public CorridorTile(int x, int y) {
        super(x, y);
    }

    public void modifyPlayer(Player player){
        player.score += 1;
    }

    public void introText(){
        System.out.println("""
                This seems to be a corridor.
                Don you not wonder where it leads.
                """);
    }
}
