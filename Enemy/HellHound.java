package Enemy;

public class HellHound extends Enemy{
    public HellHound(){
        this.name = "Hell Hound";
        this.hp = 14;
        this.damage = 18;
        this.defence = 2;
        this.type = "fire";
        this.score = 7;
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                It's getting hotter by the second.
                A %s of incredible size is before you
                Has  your luck run out?
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                The ground below you is now magma.
                You turned that %s into a hell puppy.
                You must be getting close.
                """, this.name);
    }
}
