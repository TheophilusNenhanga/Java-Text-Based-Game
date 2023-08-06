package World.FindTiles;

import MiscItems.MagicalItem;
import Player.Player;
import World.MapTile;

public class FindQuestItemTile extends MapTile {

    MagicalItem item;

    public FindQuestItemTile(int x, int y) {
        super(x, y);
        this.item = new MagicalItem();
    }

    @Override
    public void modifyPlayer(Player player) {
        if (!this.completed) {
            player.score += 5;
            this.completed = true;
            player.inventory.add(this.item);
            System.out.printf("You have found the %s.\n", this.item.name);
        }
    }

    @Override
    public void introText() {
        if (this.completed) {
            System.out.printf("""
                    There is nothing to see here.
                    It seems you have already claimed the %s.
                    You must forge onwards.
                    """, this.item.name);
        } else {
            System.out.printf("""
                    You see a soft glow.
                    You have found the %s.
                    Now you can return to the suspicious old lady.""", this.item.name);
        }
    }
}