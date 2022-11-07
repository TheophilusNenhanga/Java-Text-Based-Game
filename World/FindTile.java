package World;

import Player.Player;

public class FindTile extends MapTile{

    public FindTile(int x, int y) {
        super(x, y);
    }

    public void modifyPlayer(Player player){
        player.score += 5;
    }

    public void introText(){
        System.out.println("""
                On this tile you will find something.
                Something for you to keep.
                """);
    }


    class FindCrystalTile extends FindTile{
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

    class FindGoldTile extends FindTile{
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
}
