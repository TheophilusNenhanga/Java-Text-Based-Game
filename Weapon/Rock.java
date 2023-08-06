package Weapon;

import java.util.HashMap;

public class Rock extends Weapon {
    boolean sellable;

    public Rock() {
        super();
        this.name = "rock";
        this.description = "IA fist sized rock, perfect for bludgeoning";
        this.damage = 1;
        this.value = 5;
        this.sellable = true;
        this.attacks = new HashMap<>();
        this.addAttacks();
    }

    private void addAttacks() {
        this.attacks.put(1, new Attack("Rock Throw", 0.1, 25));
        this.attacks.put(2, new Attack("Rock Sling", 0.3, 15));
        this.attacks.put(3, new Attack("Rock Pummel", 0.5, 10));
    }
}
