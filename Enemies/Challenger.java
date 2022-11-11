package Enemies;

public class Challenger extends Enemies{
    public Challenger(){
        this.name = "Exiled Villager";
        this.hp = 90;
        this.damage = 9;
        this.defence = 0;
        this.type = "human";
        this.score = 10;
        this.reward = random.nextInt(35, 75);
    }

    @Override
    public void aliveText() {
        System.out.printf("""
                I am The %s. Nothing that you do can stop me.\\n
                """, this.name);
    }

    @Override
    public void deadText() {
        System.out.printf("""
                How can it be.
                Me, The %s.
                How could I be defeated by the likes of you.
                I must get my revenge.
                One day you shall pay for what you have done to me.\\n
                """, this.name);
    }
}
