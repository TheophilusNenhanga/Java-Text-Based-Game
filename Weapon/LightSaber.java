package Weapon;

import java.util.HashMap;

public class LightSaber extends Weapon{
    boolean sellable;
    public LightSaber() {
        super();
        this.name = "Light Saber";
        this.description = "This one is light.\nagile and sharp.";
        this.damage = 18;
        this.value = 85;
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
