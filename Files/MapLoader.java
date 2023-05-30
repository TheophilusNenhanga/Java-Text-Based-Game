package Files;


import SuperClasses.IO;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;


public class MapLoader implements IO {

    protected InputStream inputStream;
    protected Properties properties;
    protected ArrayList<String> maps;
    public ArrayList<String> mapNames;
    protected int mapNumber;

    /**
     * The MapLoader class loads the maps properties file and loads the different maps.
     */
    public MapLoader(){
        this.inputStream = null;
        this.properties = new Properties();
        this.maps = new ArrayList<>();
        this.mapNames = new ArrayList<>();
        this.mapNumber = 0;

        this.inputStream = getClass().getResourceAsStream(mapsFileName);
        try{
            this.properties.load(this.inputStream);
        } catch (IOException e){
            System.out.println("Error: Failed to read properties");
        }
        this.getMaps();
    }

    /**
     * @return The number of maps
     */
    public int mapNumber(){
        return this.maps.size();
    }

    /**
     * Gets the maps from the properties file.
     */
    private void getMaps(){
        this.properties.forEach((key, value) ->{
            this.maps.add((String) value);
            this.mapNames.add((String) key);
            this.mapNumber += 1;
        });
    }

    /**
     * Gets the maps at a given index
     * @param index The index to be queried
     * @return the map found at the given index
     */
    public String getMap(int index){
        if (index < 0){
            throw new RuntimeException("Error: There is no map at that index");
        }
        if (index > this.mapNumber){
            throw new RuntimeException("Error: There is no map at that index");
        }else{
            return this.maps.get(index-1);
        }
    }
}
