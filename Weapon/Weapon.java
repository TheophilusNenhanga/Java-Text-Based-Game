package Weapon;

import Enchantment.Enchantment;
import SuperClasses.Items;

import java.util.HashMap;

public class Weapon implements Items {
    public String name;
    public String description;
    public int damage;
    public Enchantment enchantment;
    public int value;
    HashMap<Integer, Attack> attacks;
    String typeAffect;

    public Weapon() {
        this.name = "Weapon";
        this.description = "Used for attacking";
        this.damage = 0;
        this.enchantment = null;
        this.value = 0;
        this.typeAffect = "";
    }

    @Override
    public String toString() {
        return this.name + ",\t\t" + "(Damage: " + this.damage + ")";
    }

}
//TODO: Fix implementation of addAttacks() in weapon classes.
//TODO: Add documentation.