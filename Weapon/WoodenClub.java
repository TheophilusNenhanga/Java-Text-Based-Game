package Weapon;

import java.util.HashMap;

public class WoodenClub extends Weapon {
    boolean sellable;

    public WoodenClub() {
        super();
        this.name = "Wooden Club";
        this.description = "I hope you are embarrassed.\nYou couldn't even hurt a fly";
        this.damage = 4;
        this.value = 22;
        this.sellable = true;
        this.attacks = new HashMap<>();
        this.addAttacks();
    }

    private void addAttacks() {
        this.attacks.put(1, new Attack("Club Hit", 0.1, 15));
        this.attacks.put(2, new Attack("Club Pound", 0.3, 10));
        this.attacks.put(3, new Attack("Triple Club Hammer", 0.5, 5));
    }
}
