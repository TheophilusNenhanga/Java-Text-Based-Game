package Weapon;

import java.util.HashMap;

public class Mace extends Weapon {
    boolean sellable;

    public Mace() {
        super();
        this.name = "Mace";
        this.description = "don't get too close.\nIt hurts.";
        this.damage = 28;
        this.value = 120;
        this.sellable = true;
        this.attacks = new HashMap<>();
        this.addAttacks();
    }

    private void addAttacks() {
        this.attacks.put(1, new Attack("Mace Hit", 0.1, 15));
        this.attacks.put(2, new Attack("Mace Hammer", 0.3, 10));
        this.attacks.put(3, new Attack("Triple Mace Bash", 0.5, 5));
    }
}
