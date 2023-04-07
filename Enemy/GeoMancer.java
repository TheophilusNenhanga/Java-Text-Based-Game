package Enemy;

public class GeoMancer extends Enemy{
    public GeoMancer(){
        this.name = "Geo-Mancer";
        this.hp = 50;
        this.damage = 14;
        this.defence = 0;
        this.type = "rock";
        this.score = 15;
        this.reward = random.nextInt(25, 50);
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                The ground is now shaking violently.
                The rocks in front of you begin to move.
                Spikes made of rock begin to grow out of the roof of the cave.
                You are in its presence;
                The %s!
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                The ground stops shaking.
                Everything is silent.
                The rocks before you begin to disintegrate.
                The %s is dead.

                The ground begins to crumble.
                """, this.name);
    }
}
