package Enemy;

public class Salamander extends Enemy {
    public Salamander() {
        this.name = "Salamander";
        this.hp = 10;
        this.damage = 22;
        this.defence = 2;
        this.type = "fire";
        this.score = 7;
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                It is getting hotter by the second
                A %s stands before you.
                A giant fiery lizard.
                Will you be charred?\s
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                The ground below you is magma.
                It seems nothing can stop you.
                You must be getting close.
                """, this.name);
    }
}
