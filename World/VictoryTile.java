package World;

import Player.Player;

public class VictoryTile extends MapTile{
    int gold;
    int score;
    boolean rewardClaimed;

    public VictoryTile(int x, int y) {
        super(x, y);
        gold = random.nextInt(100, 200);
        score = 300;
        rewardClaimed = false;
    }

    public void modifyPlayer(Player player){
        if (!this.rewardClaimed){
            this.rewardClaimed = true;
            player.gold += this.gold;
            player.score += this.score;
            System.out.println("+"+this.gold+ " gold added");
            System.out.println("+"+this.score+ " score added");

            player.victory = true;
        }

    }

    public void introText(){
        if (!this.rewardClaimed) {
            System.out.println("""
                    You see the light.
                    Before you leave the cave take your reward.
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
