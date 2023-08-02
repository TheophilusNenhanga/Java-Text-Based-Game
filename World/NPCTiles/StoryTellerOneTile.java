package World.NPCTiles;

import World.MapTile;

public class StoryTellerOneTile extends MapTile {
    int playerEncounter;
    String name = "Shrivelled Old Man";
    public StoryTellerOneTile(int x, int y) {
        super(x, y);
        this.playerEncounter = 0;

    }

    public void introText(){
        System.out.printf("You meet a %s lost in the labyrinth\n", name);
    }

    public void converse(){
        if (this.playerEncounter >= 1){
            System.out.printf("You have already spoken to the %s once before", name);
            this.playerEncounter += 1;
        } else if (this.playerEncounter == 7) {
            System.out.println("""
                    You meet the old man once again.
                    ...
                    He seems to have something to say.
                    """);
            this.playerEncounter += 1;
        }else{
            this.playerEncounter += 1;
        }
        // TODO: Add dialogue to the NPCs
    }
}