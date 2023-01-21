package Enemy;

public class PyroMancer extends Enemy{
    public PyroMancer(){
        this.name = "Pyro-Mancer";
        this.hp = 75;
        this.damage = 26;
        this.defence = 1;
        this.type = "fire";
        this.score = 15;
        this.reward = random.nextInt(40, 80);
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                The ground below you is now beginning to bubble.
                The heat is more than you can bear.
                The sweat falling from your face evaporates before it hits the ground
                The %s must be close by,
                and your death?
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                The temperature suddenly drops.
                The magma cools.
                You have done it.
                The great %s has fallen by your hands
                """, this.name);
    }
}
