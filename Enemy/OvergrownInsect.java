package Enemy;

public class OvergrownInsect extends Enemy {
    public OvergrownInsect(int level) {
        this.score = 2;
        this.name = "Overgrown Insect";
        switch (level) {
            case 1 -> {
                this.hp = 10;
                this.damage = 6;
            }
            case 2 -> {
                this.hp = 15;
                this.damage = 8;
            }
            case 3 -> {
                this.hp = 20;
                this.damage = 10;
            }
            case 4 -> {
                this.hp = 25;
                this.damage = 12;
            }
            default -> {
                this.hp = 15;
                this.damage = 10;
            }
        }
        this.defence = 0;
        this.type = "normal";
    }

    @Override
    public void aliveText() {
        System.out.println("""
                An overgrown insect sets its eyes on you.
                Will you make it out alive?
                """);
    }

    @Override
    public void deadText() {
        System.out.println("""
                You fought valiantly.
                Its corpse is now your trophy.
                """);
    }
}
