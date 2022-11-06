package World;

public class StartTile extends MapTile {
    public StartTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void introText() {
        System.out.println("""
                This is where your journey begins!
                Will you be the one to save the village?
                """);
    }
}
