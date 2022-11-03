package Enchantment;

public class Extinguishing extends Enchantment{
    public Extinguishing() {
        super();
        this.name = "Extinguishing";
        this.level = 1;
        this.typeEffect = new String[]{"fire"};
        this.description = "This enchantment extinguishes flames.\nSay farewell to all the flames.";
        this.value = 100;
    }
}
