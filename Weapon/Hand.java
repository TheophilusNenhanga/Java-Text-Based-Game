package Weapon;

import java.util.HashMap;

public class Hand extends Weapon{
    boolean sellable;
    public Hand() {
        super();
        this.name = "Bare Hands";
        this.description = "If all else fails.";
        this.damage = 1;
        this.value = 999999;
        this.sellable = false;
        this.attacks = new HashMap<Integer, Attack>();
        this.addAttacks();
    }
    private void addAttacks(){
        this.attacks.put(1, new Attack("Sword Slash", 0.1, 15));
        this.attacks.put(2, new Attack("Counter Attack", 0.3, 10));
        this.attacks.put(3, new Attack("Passata Sotto", 0.5, 5));
    }
}
