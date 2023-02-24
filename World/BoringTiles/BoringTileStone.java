package World.BoringTiles;

public class BoringTileStone extends BoringTile {

    public BoringTileStone(int x, int y) {
        super(x, y);
    }

    public void introText(){
        System.out.println("""
                IF you are not careful the rocks will crush you.
                Keep moving forward...
                """);
    }
}