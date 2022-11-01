package Weapon;

import java.util.HashMap;

public class Pike extends Weapon{
    boolean sellable;
    public Pike() {
        super();
        this.name = "Pike";
        this.description = "Poke, Poke, Pike!.\nAnd all the enemies take a hike!";
        this.damage = 16;
        this.value = 80;
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
