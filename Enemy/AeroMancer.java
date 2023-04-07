package Enemy;

public class AeroMancer extends Enemy{
    public AeroMancer(){
        this.name = "Aero-Mancer";
        this.hp = 80;
        this.damage = 22;
        this.defence = 2;
        this.type = "air";
        this.score = 15;
        this.reward = random.nextInt(50, 100);
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                You can barely breathe now.\s
                Will you did for suffocation before the fight begins
                Have you come this far just to die?
                Will the %s be your end?
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                A lifeless figure is all you see.
                The %s is dead.
                You have made it this far
                You are a worthy warrior.
                
                Is this the end?
                Have you really finished the game?
                
                You still do not know the answers to all the questions that cloud your mind
                
                Your journey is far from over...
                """, this.name);
    }
}
