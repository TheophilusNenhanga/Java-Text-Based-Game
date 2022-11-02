package Weapon;

import java.util.HashMap;

public class MetalClub extends Weapon{
    boolean sellable;
    public MetalClub() {
        super();
        this.name = "Metal Club";
        this.description = "Now this can put up a fight.\nEnemies beware!";
        this.damage = 9;
        this.value = 50;
        this.sellable = true;
        this.attacks = new HashMap<Integer, Attack>();
        this.addAttacks();
    }
    private void addAttacks(){
        this.attacks.put(1, new Attack("Club Hit", 0.1, 15));
        this.attacks.put(2, new Attack("Club Pound", 0.3, 10));
        this.attacks.put(3, new Attack("Triple Club Hammer", 0.5, 5));
    }
}
