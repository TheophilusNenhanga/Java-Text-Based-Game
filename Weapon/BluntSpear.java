package Weapon;

import java.util.HashMap;

public class BluntSpear extends Weapon{
    boolean sellable;
    public BluntSpear() {
        super();
        this.name = "Blunt Spear";
        this.description = "It's a spear.\nBut it will probably let you down.";
        this.damage = 6;
        this.value = 30;
        this.sellable = true;
        this.attacks = new HashMap<Integer, Attack>();
        this.addAttacks();
    }
    private void addAttacks(){
        this.attacks.put(1, new Attack("Poke", 0.1, 15));
        this.attacks.put(2, new Attack("Spear Toss", 0.3, 10));
        this.attacks.put(3, new Attack("Double Stab", 0.5, 5));
    }
}
