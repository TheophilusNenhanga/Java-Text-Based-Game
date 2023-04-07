package Enemy;

public class Manticore extends Enemy{
    public Manticore(){
        this.name = "Manticore";
        this.hp = 25;
        this.damage = 19;
        this.defence = 2;
        this.type = "air";
        this.score = 7;
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                The air is getting thinner.
                A %s stands before you.
                Is it unconquerable?
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.println("""
                You can barely breathe now.
                You have conquered the unconquerable
                Could you save humanity?
                
                You must be getting close
                """);
    }
}
