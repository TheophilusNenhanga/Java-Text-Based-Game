package Enemy;

public class Harpy extends Enemy{
    public Harpy(){
        this.name = "Harpy";
        this.hp = 22;
        this.damage = 15;
        this.defence = 0;
        this.type = "air";
        this.score = 7;
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                The air seems to be getting thinner.
                Yor mere presence has angered a %s.
                You shall face death by its talons.
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                You can barely breathe now.
                The %s has fallen.\s
                You have clipped its once might wings
                You must be getting close.\s
                """, this.name);
    }
}
