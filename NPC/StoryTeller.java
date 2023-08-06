package NPC;

import java.util.HashMap;

public class StoryTeller extends NonPlayerCharacter {

    private int playerEncounter;
    String dialogueFileName;
    protected HashMap<String, String> dialogue;

    public StoryTeller() {
        this.playerEncounter = 0;
        this.dialogueFileName = "";
    }


    public void converse() {
        if (this.playerEncounter > 1 && this.playerEncounter < 7 || this.playerEncounter > 7) {
            System.out.printf("You have already spoken to the %s once before", name);
            this.playerEncounter += 1;
        } else if (this.playerEncounter == 7) {
            System.out.println("""
                    You meet the old man once again.
                    ...
                    He seems to have something to say.
                    """);
            this.playerEncounter += 1;
        } else {
            this.conversation();
            this.playerEncounter += 1;
        }
        // TODO: Add dialogue to the NPCs
    }

    protected void conversation() {
        throw new RuntimeException("Conversation not Implemented yet");
    }

}
