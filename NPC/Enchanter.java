package NPC;

import Enchantment.*;

import java.util.ArrayList;

public class Enchanter extends NonPlayerCharacter {
    public Enchanter() {
        this.name = "Enchanter";
        this.inventory.add(new Hydration());
        this.inventory.add(new Dehydration());
        this.inventory.add(new Honed());
        this.inventory.add(new Extinguishing());
        this.inventory.add(new Suction());
    }
}
