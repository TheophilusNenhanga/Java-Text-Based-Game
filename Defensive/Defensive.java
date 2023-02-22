package Defensive;

import SuperClasses.Items;

public class Defensive implements Items {
    int value;
    String name;
    String description;
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


