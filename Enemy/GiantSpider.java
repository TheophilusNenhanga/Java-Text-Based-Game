package Enemy;

public class GiantSpider extends Enemy{
    public GiantSpider(int level){
        this.name = "Giant Spider";
        switch (level){
            case 1 -> {
                this.hp = 10;
                this.damage = 6;
            }
            case 2 -> {
                this.hp = 12;
                this.damage = 10;
            }
            case 3 -> {
                this.hp = 20;
                this.damage = 14;
            }
            case 4 -> {
                this.hp = 25;
                this.damage = 18;
            }
            default -> {
                this.hp = 10;
                this.damage = 12;
            }
        }
        this.defence = 0;
        this.type = "normal";
    }

    @Override
    public void aliveText() {
        System.out.println("""
                A Giant Spider crawls down the wall.
                It stands before you.
                You are its prey.
                """);
    }

    @Override
    public void deadText() {
        System.out.println("""
                The corpse of a dead giant spider lies before you.
                Your victory was always certain.
                """);
    }
}
