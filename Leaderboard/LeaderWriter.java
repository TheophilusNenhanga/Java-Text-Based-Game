package Leaderboard;

import SuperClasses.IO;

import java.io.*;
import java.util.Properties;

public class LeaderWriter implements IO {
    public static boolean addLeader(String name, int score){
        String scoreString = String.valueOf(score);

        try(FileInputStream fileInputStream = new FileInputStream(leaderboardFilename)){

            Properties properties = new Properties();
            properties.load(fileInputStream);

            properties.setProperty(name, scoreString);

            try (FileOutputStream fileOutputStream = new FileOutputStream(leaderboardFilename, true)){
                properties.store(fileOutputStream, null);

            }catch (IOException e){
                return false;
            }

        }catch (IOException e){
            return false;
        }
        return true;
    }
}
