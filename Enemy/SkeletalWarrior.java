package Enemy;

public class SkeletalWarrior extends Enemy{
    public SkeletalWarrior(int level){
        this.name = "Skeletal Warrior";
        switch (level){
            case 1 -> {
                this.hp = 12;
                this.damage = 9;
            }
            case 2 -> {
                this.hp = 14;
                this.damage = 11;
            }
            case 3 -> {
                this.hp = 20;
                this.damage = 14;
            }
            case 4 -> {
                this.hp = 25;
                this.damage = 17;
            }
            default -> {
                this.hp = 15;
                this.damage = 11;
            }
        }
        this.defence = 0;
        this.type = "normal";
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                The rattling of bones.
                The hastening of your death?
                A %s.
                %n""", this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                The %s is dead.
                Only its bones remain.
                """, this.name);
    }
}

