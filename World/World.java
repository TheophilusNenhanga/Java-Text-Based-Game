package World;

import java.util.*;

public class World {

    String worldString;
    HashMap<String, MapTile> tileTypes;

    int[] startLocation;

    ArrayList<ArrayList<MapTile>> worldMap;

    public World(){
        this.worldString = """
                |ST|  |  |
                |  |  |  |
                |  |VT|  |
                """;

        tileTypes = new HashMap<String, MapTile>();
    }

    public boolean isWorldValid(String world){
       /*int allPipeCount = 0;*/

        if (!world.contains("|ST|")) {
            return false;
        }
        if (!world.contains("|VT|")){
            return false;
        }

        String[] lines  = world.split("\n");

        for (int i = 0; i < lines.length-1; i++){
                if (!(lines[i].length() == lines[i + 1].length())) {
                    return false;
            }
        }

       /* for (int j = 0; j < world.length(); j++){
            if (world.charAt(j) == '|'){
                allPipeCount += 1;
            }
        }*/
        // TODO: Translate correctly from python source.
        return true;
    }

    public void parseWorld(){
        // TODO: Translate correctly from python source.
        if (!this.isWorldValid(this.worldString)){
            throw new RuntimeException("World String is Invalid");
        }

        this.worldMap = new ArrayList<>();
        String[] worldLines = this.worldString.split("\n");
         for (int y = 0; y < worldLines.length; y++){
             ArrayList<MapTile> row = new ArrayList<MapTile>();
             String worldRow =  worldLines[y];
             ArrayList<String> cell = new ArrayList<>(List.of(worldRow.split("\\|")));
             cell.removeIf(element -> Objects.equals(element, "")); // Has this effect --- for(String element: cell){if (Objects.equals(element, "")){cell.remove(element);}}
             for (int x = 0; x < cell.size(); x++){
                 System.out.println(x);
                 switch (cell.get(x)){
                     case "  " -> row.add(null);
                     case "ST" -> {row.add(new StartTile(x, y));
                                    this.startLocation = new int[]{x, y};}
                     case "VT" -> row.add(new VictoryTile(x, y));
                 }

             }
             this.worldMap.add(row);
         }
    }

    public MapTile GetTile(int x, int y){
        if (x < 0 || y < 0){
            return null;
        }
        try{
            return worldMap.get(y).get(x);
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }



    public static void main(String[] args){
        World newWorld =  new World();
        System.out.println(newWorld.isWorldValid(newWorld.worldString));
        newWorld.parseWorld();
        System.out.println(newWorld.worldMap);
    }

}



/*
# ST start Tile
        # VT Victory Tile

        # FG Find Gold
        # FC Find Crystals
        # FI Find Quest Item Tile

        # EN1 Enemy Tile1
        # EN2 Enemy Tile2
        # EN3 Enemy Tile3
        # EN4 Enemy Tile4

        # AE Aero Enemy
        # HE Hydro Enemy
        # PE Pyro enemy
        # GE Geo Enemy

        # ET Enchanter Tile
        # TT Trader Tile
        # QT Quest Tile

        # BT Boring Tile
        # Corridor Tile

        # AST Armour smith Tile
        # WST Weapon smith Tile
        # ST1 Story Teller Tile 1
        # ST2 Story Teller Tile 2

        # RCT Random Character Tile

        # LT1 Level Tile 1
        # LT1 Level Tile 2
        # LT1 Level Tile 3
        # LT1 Level Tile 4

        # STT Stone Tile Tile

        # BTS Boring Tile Stone
        # BTW Boring Tile Water
        # BTF Boring Tile Fire
        # BTA Boring Tile Air

 */