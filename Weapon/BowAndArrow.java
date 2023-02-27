package Weapon;

import java.util.HashMap;

public class BowAndArrow extends Weapon{
    boolean sellable;
    public BowAndArrow() {
        super();
        this.name = "Bow and Arrow";
        this.description = "What is stronger? \nThe bow or the arrow?";
        this.damage = 12;
        this.value = 55;
        this.sellable = true;
        this.attacks = new HashMap<>();
        this.addAttacks();

    }
    private void addAttacks(){
        this.attacks.put(1, new Attack("Bow Swipe", 0.1, 15));
        this.attacks.put(2, new Attack("Multi Arrow Shot", 0.3, 10));
        this.attacks.put(3, new Attack("Piercing Arrow Snipe", 0.5, 5));
    }
}
