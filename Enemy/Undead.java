package Enemy;

public class Undead extends Enemy{
    public Undead(int level){
        this.name = "Undead";
        switch (level){
            case 1 -> {
                this.hp = 15;
                this.damage = 5;
            }
            case 2 -> {
                this.hp = 16;
                this.damage = 8;
            }
            case 3 -> {
                this.hp = 20;
                this.damage = 11;
            }
            case 4 -> {
                this.hp = 30;
                this.damage = 14;
            }
            default -> {
                this.hp = 20;
                this.damage = 8;
            }
        }
        this.defence = 0;
        this.type = "normal";
    }

    @Override
    public void aliveText() {
        System.out.println("""
                A dead explorer's corpse rises.
                Will you join it in the exploration of death?
                """);
    }

    @Override
    public void deadText() {
        System.out.println("""
                Can a dead person die again?
                Hm, maybe...
                """);
    }
}
