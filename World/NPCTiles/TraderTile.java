package World.NPCTiles;

import NPC.Trader;
import Player.Player;
import World.MapTile;

public class TraderTile extends MapTile {
    Trader trader;
    public TraderTile(int x, int y){
        super(x, y);
        this.trader = new Trader();
    }

    @Override
    public void introText() {
        System.out.println(
                "A frail not-quite human, not-quite creature squats in the corner.\n" + "Clinking his gold coins together. He looks ready to trade."
        );
    }

    public void trade(Player buyer, Trader seller){
        //TODO: Add implementation - trading with the NPC
    }
}
