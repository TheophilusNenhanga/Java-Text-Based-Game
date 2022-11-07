package World;

import Player.Player;

public class CorridorTile extends MapTile{

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

    class CorridorTileStone extends CorridorTile {
        public CorridorTileStone(int x, int y) {
            super(x, y);
        }
        public void introText(){

        }
    }

    class CorridorTileWater extends CorridorTile {
        public CorridorTileWater(int x, int y) {
            super(x, y);
        }
        public void introText(){

        }
    }

    class CorridorTileAir extends CorridorTile {
        public CorridorTileAir(int x, int y) {
            super(x, y);
        }
        public void introText(){

        }
    }

    class CorridorTileFire extends CorridorTile {
        public CorridorTileFire(int x, int y) {
            super(x, y);
        }
        public void introText(){

        }
    }

}
