package Player;

import Consumable.CrustyBread;
import Defensive.Defensive;
import Enemy.Enemy;
import SuperClasses.Items;
import Weapon.Hand;
import Weapon.RustySword;
import Weapon.Weapon;
import World.EnemyTile;
import World.MapTile;

import java.util.ArrayList;
import java.util.Random;


public class Player {

    public boolean victory;
    public boolean kindness;
    public ArrayList<Items> inventory;
    public int x;
    public int y;
    public int gold;
    public int crystals;
    public String name;
    public float hp;
    public int score;
    public int boss;
    public static Random random = new Random();

    public Player(int x, int y) {
        this.victory = false;
        this.kindness = false;
        this.inventory = new ArrayList<>();
        this.x = x;
        this.y = y;
        this.gold = 15;
        this.crystals = 5;
        this.name = "";
        this.hp = 100;
        this.score = 0;
        this.boss = 0;

        this.inventory.add(new Hand());
        this.inventory.add(new CrustyBread());
        this.inventory.add(new RustySword());
    }

    private void fight(Weapon bestWeapon, Enemy enemy){

    }

    public void attack(EnemyTile room) {

        Enemy enemy = room.enemy;

        if (!enemy.isAlive()){
            return;
        }

        double defenceMultiplier =  0.1 * enemy.defence;
        double attackMultiplier = 1;
        Weapon bestWeapon = this.mostDamage();
        int damageDealt = (int) ((bestWeapon.damage * attackMultiplier) - (bestWeapon.damage * defenceMultiplier));
        enemy.hp =  (int) (enemy.hp - damageDealt);
        System.out.printf("You deal %d damage\n", damageDealt);

        if (!enemy.isAlive() && !room.completed){
            System.out.printf("You killed the %s\n", enemy.name);
            this.gold += enemy.reward;
            System.out.printf("You receive +%d gold.\n", enemy.reward);
            this.score += enemy.score;
            int amount = random.nextInt(0, 2);
            if (amount != 0){
                this.crystals += amount;
                System.out.printf("You receive +%d crystals\n\n", amount);
            }
        }else{
            System.out.printf("The %s has %d health remaining\n\n", enemy.name, Math.round(enemy.hp));
        }
    }

    public boolean isAlive(){
        return this.hp > 0;
    }

    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

    public void moveNorth(){
        this.move(0, -1);
    }

    public void moveEast(){
        this.move(1, 0);
    }

    public void moveSouth(){
        this.move(0, 1);
    }

    public void moveWest(){
        this.move(-1, 0);
    }

    public Weapon mostDamage(){
        Weapon bestWeapon = new Hand();
        for (int i = 0; i<this.inventory.size(); i++){
            try{
                Weapon currentWeapon = (Weapon) this.inventory.get(i);
                if (currentWeapon.damage > bestWeapon.damage){
                    bestWeapon = currentWeapon;
                }
            }catch (RuntimeException e){
                ;
            }
        }
        return bestWeapon;
    }

    public Defensive mostDefence(){
        return null;
    }

    public void heal(){

    }

    public boolean hasName(){
        return !this.name.equals("");
    }
}
