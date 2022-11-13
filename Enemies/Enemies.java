package Enemies;

import java.util.Random;

public class Enemies {
    public String name;
    int hp;
    public int damage;
    int score;
    int reward;
    int defence;
    public String type;
    Random random;

    public Enemies(){
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
