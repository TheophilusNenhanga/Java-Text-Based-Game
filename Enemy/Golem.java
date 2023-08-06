package Enemy;

public class Golem extends Enemy {
    public Golem() {
        this.name = "Golem";
        this.hp = 20;
        this.damage = 6;
        this.defence = 0;
        this.type = "rock";
        this.score = 7;
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                The ground begins to shake.
                Could it be this hunky %s.
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                The ground is still shaking.
                The %s is now just a pile of rocks.
                You must be getting closer.
                """, this.name);
    }
}
