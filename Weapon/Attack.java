package Weapon;

public class Attack {
    String attackName;
    double attackModifier;
    int attackUses;

    public Attack(String attackName, double attackModifier, int attackUses) {
        this.attackName = attackName;
        this.attackModifier = attackModifier;
        this.attackUses = attackUses;
    }
}
