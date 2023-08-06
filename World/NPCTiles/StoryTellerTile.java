package World.NPCTiles;

import NPC.NonPlayerCharacter;
import NPC.StoryTeller;
import World.MapTile;
import Player.Player;

public class StoryTellerTile extends MapTile {
    public NonPlayerCharacter npc;
    public int playerEncounter;

    public StoryTellerTile(int x, int y) {
        super(x, y);
        this.npc = new StoryTeller();
        this.playerEncounter = 0;
    }

    public void beginConversation(Player player, StoryTeller npc) {
        npc.converse();
    }
}
