package World;

import java.util.HashMap;

public class World {

    String worldString;
    HashMap<String, MapTile> tileTypes;

    public World(){
        this.worldString = """
                |ST |   |   |
                |   |   |   |
                |   |VT |   |
                """;
    }

    public boolean isWorldValid(String world){
       /*int allPipeCount = 0;*/

        if (!world.contains("|ST |")) {
            return false;
        }
        if (!world.contains("|VT |")){
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
    }



    public static void main(String[] args){
        World newWorld =  new World();
        System.out.println(newWorld.isWorldValid(newWorld.worldString));
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