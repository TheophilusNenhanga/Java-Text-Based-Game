package World.BoringTiles;

public class BoringTileFire extends BoringTile {

    public BoringTileFire(int x, int y) {
        super(x, y);
    }

    public void introText() {
        System.out.println("""
                The heat only intensifies, but there isn't much else.
                You must keep going.
                """);
    }
}