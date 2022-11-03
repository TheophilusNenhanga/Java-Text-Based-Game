package Enchantment;

public class Honed extends Enchantment{
    public Honed() {
        super();
        this.name = "Honed";
        this.level = 1;
        this.typeEffect = new String[]{"rock", "fire", "normal", "water", "air"};
        this.description = "This enchantment sharpens your sword.\nSlicing foes is now a piece of cake.";
        this.value = 100;
    }
}
