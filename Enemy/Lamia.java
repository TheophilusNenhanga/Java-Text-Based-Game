package Enemy;

public class Lamia extends Enemy {
    public Lamia(int level) {
        this.name = "Lamia";
        this.score = 5;
        switch (level) {
            case 1 -> {
                this.hp = 30;
                this.damage = 12;
            }
            case 2 -> {
                this.hp = 35;
                this.damage = 15;
            }
            case 3 -> {
                this.hp = 40;
                this.damage = 18;
            }
            case 4 -> {
                this.hp = 45;
                this.damage = 21;
            }
            default -> {
                this.hp = 25;
                this.damage = 15;
            }
        }
        this.defence = 0;
        this.type = "normal";
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                A %s stands before you.
                Has your luck run out?
                Is it time to say goodbye?
                %n""", this.name);
    }

    @Override
    public void deadText() {
        System.out.println("""
                You have escaped death.
                You might not be so lucky next time.
                """);
    }
}

