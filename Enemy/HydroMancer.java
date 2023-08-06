package Enemy;

public class HydroMancer extends Enemy {
    public HydroMancer() {
        this.name = "Hydro-Mancer";
        this.hp = 65;
        this.damage = 19;
        this.defence = 0;
        this.type = "water";
        this.score = 15;
        this.reward = random.nextInt(30, 60);
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                The crashing waves are are more violent than ever.
                The water level is rising.
                The terrace you are standing on is not enough.
                The waves are raging.
                As if a hurricane is about to erupt within the cave.
                The %s is before you.
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                The waves retreat.
                The violent storm comes to an end.
                A soft mist begins to fall.
                The %s is dead,
                You are victorious.
                """, this.name);
    }
}
