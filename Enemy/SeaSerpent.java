package Enemy;

public class SeaSerpent extends Enemy {
    public SeaSerpent() {
        this.name = "SeaSerpent";
        this.hp = 25;
        this.damage = 12;
        this.defence = 2;
        this.type = "water";
        this.score = 7;
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                You begin to hear crashing waves.
                A %s,\s
                Have you just slithered into your death?
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.println("""
                The sound of crashing waves intensifies.
                Next time you might not be that lucky.
                You must be getting close.
                """);
    }
}
