package Enchantment;

public class Suction extends Enchantment {
    public Suction() {
        super();
        this.name = "Suction";
        this.level = 1;
        this.typeEffect = new String[]{"air", "fire"};
        this.description = "This enchantment sucks in all nearby enemies.\nWonder what will happen to the air?";
        this.value = 125;
    }
}