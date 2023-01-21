package MiscItems;

import SuperClasses.Items;

public abstract class ProgressionItem implements Items{
    public String name;
    int value = 99999999;
    public boolean sellable;

    @Override
    public String toString() {
        return this.name;
    }
}