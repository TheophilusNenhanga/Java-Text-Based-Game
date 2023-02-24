package World.NPCTiles;

import World.MapTile;

public class StoryTellerTwoTile extends MapTile {
    public StoryTellerTwoTile(int x, int y) {
        super(x, y);
    }

    public void introText(){
        System.out.println("A story teller will stand here one day in the future...");
    }
}