package World;

import Player.Player;

public class BoringTile extends MapTile{

    public BoringTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void introText() {
        System.out.println("""
            This tile is a plain tile with no other functionality.
            It is also the base class for other tiles.
            """);
    }

    @Override
    public void modifyPlayer(Player player) {
        player.score += 1;
    }
    // TODO: Add Implementation of all other BoringTiles and other tiles.

    class BoringTileWater extends BoringTile{

        public BoringTileWater(int x, int y) {
            super(x, y);
        }

        public void introText(){
            System.out.println();
        }
    }
}
