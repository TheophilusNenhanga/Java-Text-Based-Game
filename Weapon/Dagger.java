package Weapon;

import java.util.HashMap;

public class Dagger extends Weapon {
    boolean sellable;

    public Dagger() {
        super();
        this.name = "dagger";
        this.description = "A small dagger.\nSomewhat more dangerous than a rock.";
        this.damage = 3;
        this.value = 20;
        this.sellable = true;
        this.attacks = new HashMap<>();
        this.addAttacks();
    }

    private void addAttacks() {
        this.attacks.put(1, new Attack("Stab", 0.1, 15));
        this.attacks.put(2, new Attack("Dagger Throw", 0.3, 15));
        this.attacks.put(3, new Attack("Dagger Slicer", 0.5, 10));
    }
}
