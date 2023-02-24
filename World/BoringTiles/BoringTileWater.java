package World.BoringTiles;

public class BoringTileWater extends BoringTile {

    public BoringTileWater(int x, int y) {
        super(x, y);
    }

    public void introText(){
        System.out.println("""
                The waters continue to rise.
                Do not stop here.
                """);
    }
}