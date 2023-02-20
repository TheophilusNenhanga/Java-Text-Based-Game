package World.FindTiles;

import Player.Player;

public class FindGoldTile extends FindTile {
    boolean goldClaimed;
    int gold;
    public FindGoldTile(int x, int y) {
        super(x, y);
        this.goldClaimed = false;
        this.gold = this.random.nextInt(100, 200);
    }

    @Override
    public void introText() {
        if (!goldClaimed){
            System.out.println("""
                        Someone seems to have dropped some gold.
                        Is it truly yours to keep?
                        """);
        }else{
            System.out.println("""
                        You've been here before.
                        There is nothing new to see here.
                        """);
        }
    }

    @Override
    public void modifyPlayer(Player player) {
        if (!this.goldClaimed){
            this.goldClaimed = true;
            player.crystals += this.gold;
            System.out.println("+" + this.gold + "gold added.");
        }
    }
}