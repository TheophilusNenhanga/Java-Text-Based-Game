package World;

import MiscItems.*;
import Player.Player;

import java.util.Scanner;

public class StoneTile extends MapTile {
    private static final Scanner scanner = new Scanner(System.in);
    public boolean taken;
    public ProgressionItem item;

    public StoneTile(int x, int y) {
        super(x, y);
        this.item = null;
        this.taken = false;
    }

    @Override
    public void modifyPlayer(Player player) {
        if (this.taken) {
            return;
        }
        switch (player.boss) {
            case 1 -> {
                this.item = new GeoStone();
                this.giveStone(player);
            }
            case 2 -> {
                this.item = new HydroStone();
                this.giveStone(player);
            }
            case 3 -> {
                this.item = new PyroStone();
                this.giveStone(player);
            }
            case 4 -> {
                this.item = new AeroStone();
                this.giveStone(player);
            }
        }
    }

    public void giveStone(Player player) {
        System.out.printf("The %s you seek lies before you\nWill you take the stone?\n", this.item.name);
        String take = scanner.nextLine();
        if (lookingForKeyWords(take, "yes")) {
            System.out.printf("You have taken the %s", this.item.name);
            player.inventory.add(this.item);
            this.taken = true;
        } else if (lookingForKeyWords(take, "no")) {
            System.out.println("You are the fated hero...CORONA");
            System.out.printf("the %s levitates towards you", this.item.name);
            System.out.println("this is something that you cannot refuse!");
            player.inventory.add(this.item);
            this.taken = true;
        } else {
            this.modifyPlayer(player);
        }
    }
}