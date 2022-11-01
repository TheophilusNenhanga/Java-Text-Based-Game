package Weapon;

import java.util.HashMap;

public class SharpSpear extends Weapon{
    boolean sellable;
    public SharpSpear() {
        super();
        this.name = "Sharp Spear";
        this.description = "It's a spear.\nThis one won't let you down.";
        this.damage = 12;
        this.value = 55;
        this.sellable = true;
        this.attacks = new HashMap<Integer, Attack>();
        this.addAttacks();
    }
    private void addAttacks(){
        this.attacks.put(1, new Attack("Sword Slash", 0.1, 15));
        this.attacks.put(2, new Attack("Counter Attack", 0.3, 10));
        this.attacks.put(3, new Attack("Passata Sotto", 0.5, 5));
    }
}
