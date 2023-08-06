package World;

import Files.MapLoader;
import World.BoringTiles.*;
import World.CorridorTiles.*;
import World.EnemyTiles.*;
import World.FindTiles.*;
import World.LevelTiles.*;
import World.NPCTiles.*;

import java.util.*;

public class World {

    String worldString;
    HashMap<String, MapTile> tileTypes;
    MapLoader mapLoader;
    public String chosenMap;

    public int[] startLocation;

    ArrayList<ArrayList<MapTile>> worldMap;

    public World(int mapIndex, MapLoader mapLoader) {
        this.worldString = mapLoader.getMap(mapIndex);
        this.mapLoader = mapLoader;

        tileTypes = new HashMap<>();
    }

    public boolean isWorldValid(String world) {
        if (!world.contains("|ST |")) {
            return false;
        }
        if (!world.contains("|VT |")) {
            return false;
        }

        String[] lines = world.split("\n");

        for (int i = 0; i < lines.length - 1; i++) {
            if (!(lines[i].length() == lines[i + 1].length())) {
                return false;
            }
        }
        return true;
    }

    public void parseWorld() {
        if (!this.isWorldValid(this.worldString)) {
            throw new RuntimeException("World String is Invalid");
        }

        this.worldMap = new ArrayList<>();
        String[] worldLines = this.worldString.split("\n");
        for (int y = 0; y < worldLines.length; y++) {
            ArrayList<MapTile> row = new ArrayList<>();
            String worldRow = worldLines[y];
            ArrayList<String> cell = new ArrayList<>(List.of(worldRow.split("\\|")));
            cell.removeIf(element -> Objects.equals(element, "")); // Has this effect --- for(String element: cell){if (Objects.equals(element, "")){cell.remove(element);}}
            for (int x = 0; x < cell.size(); x++) {
                switch (cell.get(x)) {
                    case "   " -> row.add(null);
                    case "CT " -> row.add(new CorridorTile(x, y));
                    case "CTS" -> row.add(new CorridorTileStone(x, y));
                    case "CTA" -> row.add(new CorridorTileAir(x, y));
                    case "CTF" -> row.add(new CorridorTileFire(x, y));
                    case "CTW" -> row.add(new CorridorTileWater(x, y));
                    case "BT " -> row.add(new BoringTile(x, y));
                    case "BTA" -> row.add(new BoringTileAir(x, y));
                    case "BTW" -> row.add(new BoringTileWater(x, y));
                    case "BTF" -> row.add(new BoringTileFire(x, y));
                    case "BTS" -> row.add(new BoringTileStone(x, y));
                    case "STT" -> row.add(new StoneTile(x, y));
                    case "LT1" -> row.add(new LevelOneTile(x, y));
                    case "LT2" -> row.add(new LevelTwoTile(x, y));
                    case "LT3" -> row.add(new LevelThreeTile(x, y));
                    case "LT4" -> row.add(new LevelFourTile(x, y));
                    case "EN1" -> row.add(new EnemyTile(x, y, 1));
                    case "EN2" -> row.add(new EnemyTile(x, y, 2));
                    case "EN3" -> row.add(new EnemyTile(x, y, 3));
                    case "EN4" -> row.add(new EnemyTile(x, y, 4));
                    case "FG " -> row.add(new FindGoldTile(x, y));
                    case "TT " -> row.add(new TraderTile(x, y));
                    case "GE " -> row.add(new GeoEnemyTile(x, y, 0));
                    case "HE " -> row.add(new HydroEnemyTile(x, y, 0));
                    case "PE " -> row.add(new PyroEnemyTile(x, y, 0));
                    case "AE " -> row.add(new AeroEnemyTile(x, y, 0));
                    case "GB " -> row.add(new GeoBossTile(x, y, 0));
                    case "HB " -> row.add(new HydroBossTile(x, y, 0));
                    case "PB " -> row.add(new PyroBossTile(x, y, 0));
                    case "AB " -> row.add(new AeroBossTile(x, y, 0));
                    case "ET " -> row.add(new EnchanterTile(x, y));
                    case "FC " -> row.add(new FindCrystalTile(x, y));
                    case "QT " -> row.add(new QuestTile(x, y));
                    case "FQI" -> row.add(new FindQuestItemTile(x, y));
                    case "WST" -> row.add(new WeaponSmithTile(x, y));
                    case "AST" -> row.add(new ArmourSmithTile(x, y));
                    case "RCT" -> row.add(new RandomCharacterTile(x, y));
                    case "ST1" -> row.add(new StoryTellerOneTile(x, y));
/*                    case "ST2"-> row.add(new StoryTellerTwoTile(x, y));
                    case "ST3"-> row.add(new StoryTellerThreeTile(x, y));*/
                    case "ST " -> {
                        row.add(new StartTile(x, y));
                        this.startLocation = new int[]{x, y};
                    }
                    case "VT " -> row.add(new VictoryTile(x, y));
                }
            }
            this.worldMap.add(row);
        }
    }

    public MapTile getTile(int x, int y) {
        if (x < 0 || y < 0) {
            return null;
        }
        try {
            return worldMap.get(y).get(x);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
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

        # STT Stone Tile

        # BTS Boring Tile Stone
        # BTW Boring Tile Water
        # BTF Boring Tile Fire
        # BTA Boring Tile Air

 */