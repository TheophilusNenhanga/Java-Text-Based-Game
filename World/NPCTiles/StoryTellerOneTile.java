package World.NPCTiles;

import World.MapTile;

public class StoryTellerOneTile extends MapTile {
    public StoryTellerOneTile(int x, int y) {
        super(x, y);
    }

    public void introText(){
        System.out.println("A story teller will stand here one day in the future...");
    }
}