package Enemy;

public class BatSwarm extends Enemy{
    public BatSwarm(int level){
        this.name = "Swarm of Bats";
        switch (level){
            case 1 -> {
                this.hp = 15;
                this.damage = 8;
            }
            case 2 -> {
                this.hp = 15;
                this.damage = 10;
            }
            case 3 -> {
                this.hp = 20;
                this.damage = 16;
            }
            case 4 -> {
                this.hp = 30;
                this.damage = 20;
            }
            default -> {
                this.hp = 20;
                this.damage = 15;
            }
        }
        this.defence = 0;
        this.type = "normal";
    }

    @Override
    public void aliveText() {
        System.out.printf("""
               A %s fly above your head.
               Each looking more blood thirsty than the last.
               """, this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                The %s did not stand a chance.
                """, this.name);
    }
}

