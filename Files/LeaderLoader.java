package Files;

import SuperClasses.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class LeaderLoader implements IO {
    protected InputStream inputStream;
    protected Properties properties;
    protected HashMap<Integer, String> leaders;
    protected int leaderNumber;
    private static final String fileName = "leaderboard.properties";

    public LeaderLoader(){
        this.inputStream = null;
        this.properties = new Properties();
        this.leaders = new HashMap<>();
        this.leaderNumber = 0;

        this.inputStream = getClass().getResourceAsStream(leaderboardFilename);
        try{
            this.properties.load(this.inputStream);
        }catch (IOException e){
            System.out.println("Error: failed to read properties");
        }
        this.getLeaders();
    }

    private void getLeaders(){
        this.properties.forEach((key, value) ->{
            this.leaders.put((Integer) key, (String) value);
            this.leaderNumber += 1;
        });
    }

    public String getLeader(int index){
        if (index > this.leaderNumber){
            throw new RuntimeException("Error: There is no leader at that index");
        }else{
            return (this.leaders.get(index));
        }
    }

    public int getLeaderNumber() {
        return leaderNumber;
    }

    public boolean isEmpty(){
        return this.leaderNumber == 0;
    }

    public void sortLeaders(){
        // TODO: Sort the players in the leaderboard by score 2023/04/12

    }

    public void addLeader(String playerName, int playerScore) {
        if (!LeaderWriter.addLeader(playerName, playerScore)){
            System.out.println("---FAILED TO ADD TO LEADERBOARD---");
            return;
        }
        this.leaderNumber += 1;
        System.out.println("---SUCCESSFULLY SAVED TO LEADERBOARD---");
    }
}
