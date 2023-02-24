package Consumable;

import SuperClasses.Items;

/**Base class for all items used to restore health*/
public class Consumable implements Items {
    public int value;
    public String name;
    public int healingValue;
    boolean sellable;

    public Consumable() {
        this.value = 1;
        this.name = "Consumable";
        this.healingValue = 1;
        this.sellable = true;
    }

    @Override
    public String toString() {
        return this.name + "\t\t(+" + this.healingValue + "HP)";
    }
}
