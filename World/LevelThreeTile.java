package World;

public class LevelThreeTile extends MapTile {
    public LevelThreeTile(int x, int y){
        super(x, y);
    }

    @Override
    public void introText() {
        System.out.println("\nLEVEL 3\n");
    }
}