package World;

import Player.Player;

public class VictoryTile extends MapTile{
    int gold;
    boolean goldClaimed;

    public VictoryTile(int x, int y) {
        super(x, y);
        gold = random.nextInt(100, 200);
        goldClaimed = false;
    }

    public void modifyPlayer(Player player){
        player.score += 5;
        if (!this.goldClaimed){
            this.goldClaimed = true;
            player.gold += this.gold;
            System.out.println("+"+this.gold+ " gold added");
        }

    }

    public void introText(){
        if (!this.goldClaimed) {
            System.out.println("""
                    You see the light.
                    Before you leave the cave take your gold.
                    """);
        }else{
            System.out.println("""
                    This is where your journey ends.
                    This is where your story begins.
                    You are a CAVER!
                    """);
        }
    }
}
