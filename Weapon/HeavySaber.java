package Weapon;

import java.util.HashMap;

public class HeavySaber extends Weapon{
    boolean sellable;
    public HeavySaber() {
        super();
        this.name = "Heavy Saber";
        this.description = "Much heavier.\nMuch more damage.";
        this.damage = 24;
        this.value = 105;
        this.sellable = true;
        this.attacks = new HashMap<Integer, Attack>();
        this.addAttacks();
    }
    private void addAttacks(){
        this.attacks.put(1, new Attack("Saber Swipe", 0.1, 15));
        this.attacks.put(2, new Attack("Counter Attack", 0.3, 10));
        this.attacks.put(3, new Attack("Double Slash", 0.5, 5));
    }
}
