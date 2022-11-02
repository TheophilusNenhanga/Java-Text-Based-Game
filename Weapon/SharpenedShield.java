package Weapon;

import java.util.HashMap;

public class SharpenedShield extends Weapon{
    boolean sellable;
    public SharpenedShield() {
        super();
        this.name = "Sharpened Shield";
        this.description = "It may just be a shield\nBut keep your distance.";
        this.damage = 10;
        this.value = 80;
        this.sellable = true;
        this.defence = 2;
        this.attacks = new HashMap<Integer, Attack>();
        this.addAttacks();
    }
    private void addAttacks(){
        this.attacks.put(1, new Attack("Shield Slash", 0.1, 15));
        this.attacks.put(2, new Attack("Counter Attack", 0.3, 10));
        this.attacks.put(3, new Attack("Shield Bash", 0.5, 5));
    }
}
