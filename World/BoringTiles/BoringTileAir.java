package World.BoringTiles;

public class BoringTileAir extends BoringTile {

    public BoringTileAir(int x, int y) {
        super(x, y);
    }

    public void introText() {
        System.out.println("""
                This is nothing but a boring windy open space.
                You must journey on.
                """);
    }
}