package Weapon;

import java.util.HashMap;

public class Excalibur extends Weapon {
    boolean sellable;

    public Excalibur() {
        super();
        this.name = "Excalibur";
        this.description = "A legendary sword.\nForged long ago outside the cave.\nIt cannot rest until more blood is shed.";
        this.damage = 35;
        this.value = 300;
        this.sellable = true;
        this.attacks = new HashMap<>();
        this.addAttacks();
    }

    private void addAttacks() {
        this.attacks.put(1, new Attack("Sword Slash", 0.1, 15));
        this.attacks.put(2, new Attack("Counter Attack", 0.3, 10));
        this.attacks.put(3, new Attack("Passata Sotto", 0.5, 5));
    }
}
