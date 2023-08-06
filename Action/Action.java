package Action;

import Player.Player;
import World.EnemyTiles.EnemyTile;
import World.MapTile;

public abstract class Action {

    public String name;
    public String hotkey;
    public Player player;

    public Action(Player player) {
        this.player = player;
    }

    /**
     * Performs an action.
     * Other classes will override this method.
     */
    public void actionPerformed() {
    }

    public static class details extends Action {
        /**
         * This class prints the player's details.
         *
         * @param player The player whose details will be printed.
         */
        public details(Player player) {
            super(player);
            this.name = "Print Player Details";
            this.hotkey = "d";
        }

        @Override
        public void actionPerformed() {
            System.out.println("\n-----Player Details-----");
            System.out.println("Victory: " + this.player.victory);
            System.out.println("Name: " + this.player.name);
            System.out.println("x: " + this.player.x);
            System.out.println("y: " + this.player.y);
            System.out.println("Score: " + this.player.score);
        }
    }

    public static class inventory extends Action {
        /**
         * This class prints the player's inventory.
         *
         * @param player The player whose inventory will be printed.
         */
        public inventory(Player player) {
            super(player);
            this.name = "Print Player Inventory";
            this.hotkey = "i";
        }

        @Override
        public void actionPerformed() {
            System.out.println("\n-----Player Inventory-----");
            System.out.println("Gold: " + this.player.gold);
            System.out.println("Crystals: " + this.player.crystals);
            for (int i = 0; i < this.player.inventory.size(); i++) {
                System.out.println(i + 1 + ". " + this.player.inventory.get(i));
            }
        }
    }

    public static class converse extends Action {
        /**
         * This class allows the player to speak to NPCs
         *
         * @param player The player who will speak to NPCs
         */
        public converse(Player player) {
            super(player);
            this.name = "Converse";
            this.hotkey = "c";
        }

        @Override
        public void actionPerformed() {
            player.converse();
        }
    }

    public static class trade extends Action {
        /**
         * This class allows the player to trade (consumables) with NPCs
         *
         * @param player The player that will trade with NPCs
         */
        public trade(Player player) {
            super(player);
            this.name = "Trade";
            this.hotkey = "t";
        }

        @Override
        public void actionPerformed() {
            player.trade();
        }
    }

    public static class tradeArmour extends Action {
        /**
         * This class allows the player to trade (armour) with NPCs
         *
         * @param player The player that will trade with NPCs
         */
        public tradeArmour(Player player) {
            super(player);
            this.name = "Trade";
            this.hotkey = "t";
        }

        @Override
        public void actionPerformed() {
            player.tradeArmour();
        }
    }


    public static class tradeWeapon extends Action {
        /**
         * This class allows the player to trade (weapons) with NPCs
         *
         * @param player The player that will trade with NPCs
         */
        public tradeWeapon(Player player) {
            super(player);
            this.name = "Trade";
            this.hotkey = "t";
        }

        @Override
        public void actionPerformed() {
            player.tradeWeapon();
        }
    }

    public static class enchant extends Action {
        /**
         * This allows the player to enchant items
         *
         * @param player the player that will enchant items
         */
        public enchant(Player player) {
            super(player);
            this.name = "Enchant";
            this.hotkey = "en";
        }

        @Override
        public void actionPerformed() {
            player.enchant();
        }
    }

    public static class attack extends Action {
        MapTile room;

        /**
         * This class allows teh player to attack enemies
         *
         * @param player The player that will attack
         * @param room   The room that the player is attacking in
         */
        public attack(Player player, MapTile room) {
            super(player);
            this.name = "Attack";
            this.hotkey = "a";
            this.room = room;
        }

        @Override
        public void actionPerformed() {
            player.attack((EnemyTile) room);
        }
    }

    public static class north extends Action {
        /**
         * This class allows the player to move north
         *
         * @param player The player that will move north
         */
        public north(Player player) {
            super(player);
            this.name = "Go North";
            this.hotkey = "n";
        }

        @Override
        public void actionPerformed() {
            player.moveNorth();
        }
    }

    public static class east extends Action {
        /**
         * This class allows the player to move east
         *
         * @param player The player that will move east
         */
        public east(Player player) {
            super(player);
            this.name = "Go East";
            this.hotkey = "e";
        }

        @Override
        public void actionPerformed() {
            player.moveEast();
        }
    }

    public static class south extends Action {
        /**
         * This class allows the player to move south
         *
         * @param player The player that will move
         */
        public south(Player player) {
            super(player);
            this.name = "Go South";
            this.hotkey = "s";
        }

        @Override
        public void actionPerformed() {
            player.moveSouth();
        }
    }

    public static class west extends Action {
        /**
         * This class allows the player to move west
         *
         * @param player The player that will move
         */
        public west(Player player) {
            super(player);
            this.name = "Go West";
            this.hotkey = "w";
        }

        @Override
        public void actionPerformed() {
            player.moveWest();
        }
    }

    public static class heal extends Action {
        public heal(Player player) {
            super(player);
            this.name = "Heal";
            this.hotkey = "h";
        }

        @Override
        public void actionPerformed() {
            player.heal();
        }
    }
}
