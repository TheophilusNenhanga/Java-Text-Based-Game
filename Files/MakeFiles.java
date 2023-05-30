package Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is used to create files when the game is first run.
 * */
public class MakeFiles {

    public static void createLeaderboard() {
        File file = new File("leaderboard.properties");
        if (!file.exists()) {
            try {
                Properties properties = new Properties();
                FileOutputStream outputStream = new FileOutputStream("leaderboard.properties");
                properties.store(outputStream, "Game Leaderboard");
                outputStream.close();
            } catch (IOException e) {
                System.out.println("---Error: Failed to make properties file---");
            }
        }
    }

}
