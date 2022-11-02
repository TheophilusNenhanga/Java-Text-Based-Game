package Consumables;

public class HealingPotion extends Consumable{
    public HealingPotion() {
        super();
        this.value = 40;
        this.name = "Healing Potion";
        this.healingValue = 25;
        this.sellable = true;
    }
}
