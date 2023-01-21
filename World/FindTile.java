package World;

import Player.Player;

public class FindTile extends MapTile{

    public FindTile(int x, int y) {
        super(x, y);
    }

    public void modifyPlayer(Player player){
        player.score += 5;
    }

    public void introText(){
        System.out.println("""
                On this tile you will find something.
                Something for you to keep.
                """);
    }

}
