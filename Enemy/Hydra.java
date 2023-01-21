package Enemy;

public class Hydra extends Enemy{
    public Hydra(){
        this.name = "Hydra";
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
                A %s stands before you.
                All of its eyes looking straight at you.
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                The sound of crashing waves intensifies.
                The %s is dead, and you have three heads to prove it. 
                You must be getting close. 
                """, this.name);
    }
}
