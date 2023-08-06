package World.BoringTiles;

import Player.Player;
import World.MapTile;

public class BoringTile extends MapTile {

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
}
