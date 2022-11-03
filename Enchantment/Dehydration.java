package Enchantment;

public class Dehydration extends Enchantment{
    public Dehydration() {
        super();
        this.name = "dehydration";
        this.level = 1;
        this.typeEffect = new String[]{"water"};
        this.description = "This enchantment dehydrates all it touches.\nWonder what happens to a dry water.";
        this.value = 75;
    }
}
