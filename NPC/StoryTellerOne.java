package NPC;

import Dialogue.DialogueReader;

import java.util.HashMap;

public class StoryTellerOne extends StoryTeller {

    HashMap<String, String> dialogue;

    public StoryTellerOne() {
        this.dialogueFileName = "Dialogue/StoryTeller1.json";

        this.dialogue = DialogueReader.getDialogue(this.dialogueFileName);
    }


    @Override
    protected void conversation() {
        System.out.println(this.dialogue);
    }
}
