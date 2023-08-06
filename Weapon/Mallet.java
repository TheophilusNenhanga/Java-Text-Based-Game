package Weapon;

import java.util.HashMap;

public class Mallet extends Weapon {
    boolean sellable;

    public Mallet() {
        super();
        this.name = "Sharpened Shield";
        this.description = "It may just be a shield\nBut keep your distance.";
        this.damage = 10;
        this.value = 80;
        this.sellable = true;
        this.attacks = new HashMap<>();
        this.addAttacks();
    }

    private void addAttacks() {
        this.attacks.put(1, new Attack("Mallet Pound", 0.1, 15));
        this.attacks.put(2, new Attack("Counter Attack", 0.3, 10));
        this.attacks.put(3, new Attack("Mallet Heavy Bash", 0.5, 5));
    }
}
