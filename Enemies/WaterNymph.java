package Enemies;

public class WaterNymph extends Enemies{
    public WaterNymph(){
        this.name = "WaterNymph";
        this.hp = 20;
        this.damage = 10;
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
