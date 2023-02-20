package World.NPCTiles;

import NPC.WeaponSmith;
import Player.Player;
import World.MapTile;

public class WeaponSmithTile extends MapTile {
    WeaponSmith trader;
    public WeaponSmithTile(int x, int y){
        super(x, y);
        this.trader = new WeaponSmith();
    }

    @Override
    public void introText() {
        System.out.println(
                "A frail not-quite human, not-quite creature squats in the corner.\n" + "Clinking his gold coins together. He looks ready to trade."
        );
    }

    public void trade(Player buyer, WeaponSmith seller){
        //TODO: Add implementation - trading with the NPC
    }
}