package World;

import NPC.ArmourSmith;
import Player.Player;

public class ArmourSmithTile extends MapTile{
    ArmourSmith trader;
    public ArmourSmithTile(int x, int y){
        super(x, y);
        this.trader = new ArmourSmith();
    }

    @Override
    public void introText() {
        System.out.println(
                "A frail not-quite human, not-quite creature squats in the corner.\n" + "Clinking his gold coins together. He looks ready to trade."
        );
    }

    public void trade(Player buyer, ArmourSmith seller){
        //TODO: Add implementation - trading with the NPC
    }
}