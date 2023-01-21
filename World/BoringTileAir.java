package World;

import World.BoringTile;

class BoringTileAir extends BoringTile {

    public BoringTileAir(int x, int y) {
        super(x, y);
    }

    public void introText(){
        System.out.println();
    }
}