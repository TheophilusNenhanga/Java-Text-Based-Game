package Files;

import SuperClasses.Loaders;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class LeaderLoader implements Loaders {
    protected InputStream inputStream;
    protected Properties properties;
    protected HashMap<Integer, String> leaders;
    protected int leaderNumber;

    public LeaderLoader(){
        this.inputStream = null;
        this.properties = new Properties();
        this.leaders = new HashMap<>();
        this.leaderNumber = 0;

        this.inputStream = getClass().getResourceAsStream("leaders.properties");
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
}
