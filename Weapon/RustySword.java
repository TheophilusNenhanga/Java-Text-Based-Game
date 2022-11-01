package Weapon;

import java.util.HashMap;

public class RustySword extends Weapon{
    boolean sellable;
    public RustySword() {
        super();
        this.name = "Rusty Sword";
        this.description = "A small sword with some rust.\nIt has definitely seen better days.";
        this.damage = 8;
        this.value = 35;
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
