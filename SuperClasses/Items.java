package SuperClasses;

public class Items {
    public int damage;
    public String name;
    public int defence;

    public Items(){
        this.damage = 0;
        this.name = "Items Superclass";
        this.defence = 0;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
