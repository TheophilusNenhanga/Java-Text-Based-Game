package Consumable;

import java.util.Random;

public class LuckyFruit extends Consumable {
    public LuckyFruit() {
        super();
        Random random = new Random();
        this.value = random.nextInt(30, 60);
        this.name = "Lucky Fruit";
        this.healingValue = random.nextInt(20, 40);
        this.sellable = true;
    }
}
