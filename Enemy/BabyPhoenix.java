package Enemy;

public class BabyPhoenix extends Enemy{
    public BabyPhoenix(){
        this.name = "BabyPhoenix";
        this.hp = 8;
        this.damage = 22;
        this.defence = 2;
        this.type = "fire";
        this.score = 7;
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                It's getting hotter by the second.
                A %s flaps its fiery wings
                Will you burned along with everything else?
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                The ground below you is now magma.
                You have extinguished the %s.
                You must be getting close.
                """, this.name);
    }
}
