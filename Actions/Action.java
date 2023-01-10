package Actions;

import Player.Player;
public class Action {

    public String name;
    public String hotkey;
    public Player player;

    public Action(Player player){
        this.player = player;
    }

    public void actionPerformed(){}

    public static class details extends Action{
        public details(Player player){
            super(player);
            this.name = "Print Player Details";
            this.hotkey = "d";
        }

        @Override
        public void actionPerformed() {
            System.out.println("\n-----Player Details-----");
            System.out.println("Name: "+this.player.name);
            System.out.println("x: "+this.player.x);
            System.out.println("y: "+this.player.y);
            System.out.println("Score: "+this.player.score);
        }
    }

    public static class inventory extends Action{
        public inventory(Player player){
            super(player);
            this.name = "Print Player Inventory";
            this.hotkey = "i";
        }

        @Override
        public void actionPerformed() {
            System.out.println("\n-----Player Inventory-----");
            for (int i=0; i<this.player.inventory.size(); i++){
                System.out.println(i+1 + ". " + this.player.inventory.get(i));
            }
        }
    }

    public static class talk extends Action{
        public talk(Player player){
            super(player);
            this.name = "Talk";
            this.hotkey = "t";
        }
    }

    public static class trade extends Action{
        public trade(Player player){
            super(player);
            this.name = "Trade";
            this.hotkey = "t";
        }
    }

    public static class enchant extends Action{
        public enchant(Player player){
            super(player);
            this.name = "Enchant";
            this.hotkey = "en";
        }
    }

    public static class attack extends Action{
        public attack(Player player){
            super(player);
            this.name = "Attack";
            this.hotkey = "a";
        }
    }

    public static class north extends Action{
        public north(Player player){
            super(player);
            this.name = "Go North";
            this.hotkey = "n";
        }

        @Override
        public void actionPerformed() {
            player.move(0, -1);
        }
    }

    public static class east extends Action{
        public east(Player player){
            super(player);
            this.name = "Go East";
            this.hotkey = "e";
        }
        @Override
        public void actionPerformed(){
            player.move(1, 0);
        }
    }

    public static class south extends Action{
        public south(Player player){
            super(player);
            this.name = "Go South";
            this.hotkey = "s";
        }
        @Override
        public void actionPerformed() {
            player.move(0, 1);
        }
    }

    public static class west extends Action{
        public west(Player player){
            super(player);
            this.name = "Go West";
            this.hotkey = "w";
        }
        @Override
        public void actionPerformed() {
            player.move(-1, 0);
        }
    }
}
