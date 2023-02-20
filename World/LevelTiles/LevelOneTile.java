package World.LevelTiles;

import World.MapTile;

public class LevelOneTile extends MapTile {
    public LevelOneTile(int x, int y){
        super(x, y);
    }

    @Override
    public void introText() {
        System.out.println("\nLEVEL 1\n");
    }
}