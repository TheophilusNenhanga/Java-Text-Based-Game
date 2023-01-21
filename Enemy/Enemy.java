package Enemy;

import java.util.Random;

public class Enemy {
    public String name;
    public int hp;
    public int damage;
    public int score;
    public int reward;
    public int defence;
    public String type;
    Random random;

    public Enemy(){
        this.random = new Random();
        this.name = "Enemy";
        this.hp = 0;
        this.damage = 0;
        this.defence = 0;
        this.score = 5;
        this.reward = random.nextInt(1, 8);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean isAlive(){
        return this.hp > 0;
    }

    public void aliveText(){
        System.out.println("The " + this.name + " is still alive.");
    }

    public void deadText(){
        System.out.println("The " + this.name + "has been defeated.");
    }
}
