package Weapon;

import java.util.HashMap;

public class BattleAxe extends Weapon{
    boolean sellable;
    public BattleAxe() {
        super();
        this.name = "Battle Axe";
        this.description = "You can't battle without it.\nYou can't lose with it.";
        this.damage = 28;
        this.value = 125;
        this.sellable = true;
        this.attacks = new HashMap<Integer, Attack>();
        this.addAttacks();
    }
    private void addAttacks(){
        this.attacks.put(1, new Attack("Basic Chop", 0.1, 15));
        this.attacks.put(2, new Attack("Swift Chop", 0.3, 10));
        this.attacks.put(3, new Attack("Axe Cleave", 0.5, 5));
    }
}
