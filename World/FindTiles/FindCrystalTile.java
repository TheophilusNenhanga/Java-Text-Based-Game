package World.FindTiles;

import Player.Player;
public class FindCrystalTile extends FindTile {
    boolean crystalClaimed;
    int crystals;
    public FindCrystalTile(int x, int y) {
        super(x, y);
        this.crystalClaimed = false;
        this.crystals = this.random.nextInt(7, 15);
    }

    @Override
    public void introText() {
        if (!crystalClaimed){
            System.out.println("""
                        You see something glowing in the distance.
                        Could it be...a crystal?
                        Do you not wonder what it could be used for?
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
        if (!this.crystalClaimed){
            this.crystalClaimed = true;
            player.crystals += this.crystals;
            System.out.println("+" + this.crystals + "crystals added.");
        }
    }
}