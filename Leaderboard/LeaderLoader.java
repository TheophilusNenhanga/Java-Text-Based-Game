package Leaderboard;

import SuperClasses.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class LeaderLoader implements IO {
    protected Properties properties;
    protected int leaderNumber;
    private final ArrayList<Leader> gameLeaders;

    public LeaderLoader(){
        this.properties = new Properties();
        this.gameLeaders = new ArrayList<>();
        this.leaderNumber = 0;

        try{
            FileInputStream fileInputStream = new FileInputStream(leaderboardFilename);
            this.properties.load(fileInputStream);
        }catch (IOException e){
            System.out.println("Error: failed to read properties");
        }
        this.getLeaders();
    }

    private void getLeaders(){
        for (String key: properties.stringPropertyNames()){
            String value = properties.getProperty(key);

            Leader leader = new Leader(key, Integer.parseInt(value));
            gameLeaders.add(leader);

            this.leaderNumber += 1;
        }
    }

    public Leader getLeader(int index){
        this.sortLeaders();
        if (index >= this.leaderNumber){
            throw new RuntimeException("Error: There is no leader at that index");
        }else{
            return this.gameLeaders.get(index);
        }
    }

    public int getLeaderNumber() {
        return leaderNumber;
    }

    public boolean isEmpty(){
        return this.leaderNumber == 0;
    }

    public void sortLeaders(){
        // Sorts the leaders in reverse order
        this.gameLeaders.sort(new Comparator<Leader>() {
            @Override
            public int compare(Leader o2, Leader o1) {
                return Integer.compare(o1.getLeaderScore(), o2.getLeaderScore());
            }
        });

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
