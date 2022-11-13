package Weapon;

import Enchantment.Enchantment;
import SuperClasses.Items;

import java.util.HashMap;

public class Weapon extends Items {
    String name;
    String description;
    int damage;
    Enchantment enchantment;
    int defence;
    int value;
    HashMap<Integer, Attack> attacks;
    String typeAffect;

    public Weapon() {
        this.name = "Weapon";
        this.description = "Used for attacking";
        this.damage = 0;
        this.enchantment = null;
        this.defence = 0;
        this.value = 0;
        this.typeAffect = "";
    }

    @Override
    public String toString() {
        return this.name + ", " + "(Damage: " + this.damage + ")";
    }

}
//TODO: Fix implementation of addAttacks() in weapon classes.
//TODO: Add documentation.