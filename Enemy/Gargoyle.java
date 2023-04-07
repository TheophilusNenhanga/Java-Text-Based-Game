package Enemy;

public class Gargoyle extends Enemy{
    public Gargoyle(){
        this.name = "Gargoyle";
        this.hp = 24;
        this.damage = 8;
        this.defence = 0;
        this.type = "rock";
        this.score = 7;
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                The ground begins to shake.
                The %s sheds its stony exterior.
                It is ready to attack.
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.println("""
                The ground is still shaking.
                Even its stony skin wouldn't even stand a chance.
                You must be getting closer.
                """);
    }
}
