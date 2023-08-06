package Weapon;

import java.util.HashMap;

public class ShinySword extends Weapon {
    boolean sellable;

    public ShinySword() {
        super();
        this.name = "Shiny Sword";
        this.description = "This one has some shine to it.\nAnd iit packs a real punch";
        this.damage = 14;
        this.value = 70;
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
