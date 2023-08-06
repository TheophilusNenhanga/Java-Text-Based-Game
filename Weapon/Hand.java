package Weapon;

import java.util.HashMap;

public class Hand extends Weapon {
    boolean sellable;

    public Hand() {
        super();
        this.name = "Bare Hands";
        this.description = "If all else fails.";
        this.damage = 1;
        this.value = 999999;
        this.sellable = false;
        this.attacks = new HashMap<>();
        this.addAttacks();
    }

    private void addAttacks() {
        this.attacks.put(1, new Attack("Right Jab", 0.1, 35));
        this.attacks.put(2, new Attack("Left Hook", 0.3, 20));
        this.attacks.put(3, new Attack("Upper Cut", 0.5, 10));
    }
}
