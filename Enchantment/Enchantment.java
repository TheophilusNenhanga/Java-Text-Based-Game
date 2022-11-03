package Enchantment;

public class Enchantment {
    String name;
    short level;
    String[] typeEffect;
    String description;
    short value;

    public Enchantment() {
        this.name = "Enchantment";
        this.level = 0;
        this.typeEffect = new String[]{"normal"};
        this.description = "A magical spell embedded into your weapon.\nThis might just come in handy.";
        this.value = 0;
    }

    public float damageMultiplier(){
        float damage_multiplier;
        switch (this.level){
            case 0 -> {damage_multiplier=1f;}
            case 1 -> {damage_multiplier=1.25f;}
            case 2 -> {damage_multiplier=1.5f;}
            case 3 -> {damage_multiplier=2f;}
            default -> {damage_multiplier=1.1f;}
        }
        return damage_multiplier;
    }
}
