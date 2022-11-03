package Enchantment;

public class Hydration extends Enchantment{
    public Hydration() {
        super();
        this.name = "Hydration";
        this.level = 1;
        this.typeEffect = new String[]{"rock", "fire"};
        this.description = "This enchantment hydrates all it touches.\nWonder what happens to a wet rock..";
        this.value = 50;
    }
}
