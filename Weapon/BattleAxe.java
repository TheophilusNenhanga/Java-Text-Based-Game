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
        this.attacks.put(1, new Attack("Sword Slash", 0.1, 15));
        this.attacks.put(2, new Attack("Counter Attack", 0.3, 10));
        this.attacks.put(3, new Attack("Passata Sotto", 0.5, 5));
    }
}
