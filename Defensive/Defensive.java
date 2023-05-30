package Defensive;

import SuperClasses.Items;

/**
 * The base class for all defensive items.
 * Defensive items reduce the effects of enemy attacks.
 */
public class Defensive implements Items {
    public int value;
    public String name;
    public String description;
    public float defence;
    Boolean sellable;

    public Defensive(){
        this.value = 1;
        this.name =  "Defensive";
        this.description = "It will protect you";
        this.defence = 0.1f;
        this.sellable =true;
    }

    @Override
    public String toString() {
        return this.name + ", Defence: (" + this.defence + ")";
    }
}


