package Enchantment;

public class Slayer extends Enchantment {
    public Slayer() {
        super();
        this.name = "Human Slayer";
        this.level = 3;
        this.typeEffect = new String[]{"human"};
        this.description = "This enchantment wants one thing\nHuman blood...but who's?";
        this.value = 200;
    }
}
