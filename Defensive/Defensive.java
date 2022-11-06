package Defensive;

import SuperClasses.Items;

public class Defensive extends Items {
    int value;
    String name;
    float defence;
    Boolean sellable;

    public Defensive(){
        this.value = 1;
        this.name =  "Defensive";
        this.defence = 0.1f;
        this.sellable =true;
    }

    @Override
    public String toString() {
        return this.name + ", Defence: (" + this.defence + ")";
    }
}


