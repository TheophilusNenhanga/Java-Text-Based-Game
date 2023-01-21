package Enemy;

public class ThunderBird extends Enemy{
    public ThunderBird(){
        this.name = "Thunder Bird";
        this.hp = 25;
        this.damage = 20;
        this.defence = 2;
        this.type = "air";
        this.score = 7;
    }

    @Override
    public void aliveText() {
        System.out.printf("""
            The air seems to be getting thinner.
            Will you survive its onslaught?
            A %s appears.
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                You can barely breathe now.
                The %s is dead.
                Hmm, how much do those feathers cost?

                You must be getting close.
                """, this.name);
    }
}
