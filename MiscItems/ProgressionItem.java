package MiscItems;

import SuperClasses.Items;

public abstract class ProgressionItem implements Items {
    public String name;
    int value = 999999999;
    public boolean sellable = false;

    @Override
    public String toString() {
        return this.name;
    }
}