package World.LevelTiles;

import World.MapTile;

public class LevelFourTile extends MapTile {
    public LevelFourTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void introText() {
        System.out.println("\nLEVEL 4\n");
    }
}