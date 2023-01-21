package World;

public class LevelTwoTile extends MapTile {
    public LevelTwoTile(int x, int y){
        super(x, y);
    }

    @Override
    public void introText() {
        System.out.println("\nLEVEL 2\n");
    }
}