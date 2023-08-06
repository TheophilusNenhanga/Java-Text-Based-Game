package World.NPCTiles;

import NPC.StoryTellerOne;
import World.MapTile;

public class StoryTellerOneTile extends StoryTellerTile {
    int playerEncounter;
    String name = "Shrivelled Old Man";

    public StoryTellerOneTile(int x, int y) {
        super(x, y);
        this.npc = new StoryTellerOne();
    }

    public void introText() {
        System.out.printf("You meet a %s lost in the labyrinth\n", name);
    }
}