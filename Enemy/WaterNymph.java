package Enemy;

public class WaterNymph extends Enemy{
    public WaterNymph(){
        this.name = "Water Nymph";
        this.hp = 20;
        this.damage = 8;
        this.defence = 2;
        this.type = "water";
        this.score = 7;
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                You begin to hear crashing waves.
                You have disturbed the waters of a %s.
                You have incurred her wrath.
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.println("""
                The sound of crashing waves intensifies.
                She did not stand a chance.
                You must be getting close.
                """);
    }
}
