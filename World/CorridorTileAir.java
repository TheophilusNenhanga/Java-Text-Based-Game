package World;

import World.CorridorTile;

class CorridorTileAir extends CorridorTile {
    public CorridorTileAir(int x, int y) {
        super(x, y);
    }
    public void introText(){
        System.out.println("This is a airy corridor");
    }
}