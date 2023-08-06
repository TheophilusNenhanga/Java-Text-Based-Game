package Dialogue;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DialogueReader {

    public static HashMap<String, String> getDialogue(String filename) {
        JSONParser jsonParser = new JSONParser();
        HashMap<String, String> dialogue = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(filename);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

            // Convert the JSONObject to a Map
            for (Object key : jsonObject.keySet()) {
                String dialogueKey = (String) key;
                String dialogueValue = (String) jsonObject.get(dialogueKey);
                dialogue.put(dialogueKey, dialogueValue);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return dialogue;
    }
}
