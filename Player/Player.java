package Player;

import Consumables.CrustyBread;
import Defensive.Defensive;
import Enemies.Enemies;
import SuperClasses.Items;
import Weapon.Hand;
import Weapon.RustySword;
import Weapon.Weapon;
import Game.Game;
import World.EnemyTile;
import World.MapTile;

import java.util.Objects;


public class Player {

    public boolean victory;
    public boolean kindness;
    public Items[] inventory;
    public int x;
    public int y;
    public int gold;
    public int crystals;
    public String name;
    public float hp;
    public int score;
    public int boss;

    public Player(int x, int y) {
        // TODO: Store objects of different types in one container.
        this.victory = false;
        this.kindness = false;
        this.inventory = new Items[]{new Hand(), new RustySword(), new CrustyBread()};
        this.x = x;
        this.y = y;
        this.gold = 15;
        this.crystals = 5;
        this.name = "";
        this.hp = 100;
        this.score = 0;
        this.boss = 0;
    }

    private void fight(Items bestWeapon, Enemies enemy){
        // TODO: add implementation.
        String affectType = bestWeapon.typeAffect;

        if (Objects.equals(bestWeapon.typeAffect, enemy.type)){
            ;
            // TODO: Fix weapons and Items
        }
    }

    public void attack() {
        MapTile room = Game.world.GetTile(this.x, this.y);
        Enemies enemy;
        if (room.enemy != null) {
            enemy = room.enemy;
        } else {
            System.out.println("There is no enemy in this room.");
            return;
        }

        if (!enemy.isAlive()){
            System.out.println("The enemy is dead.");
            return;
        }

        Items bestWeapon = this.mostDamage();
        fight(bestWeapon, enemy);

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

    public void printInventory(){
        System.out.println("---Inventory---\n");
        for (Items item: this.inventory){
            System.out.println("* " + item);
        }
        System.out.println("Gold: " + this.gold);
        System.out.println("Crystals: " + this.crystals);
    }

    public Items mostDamage(){
        Items bestWeapon = new Items();
        for (Items item: this.inventory){
            if (item instanceof Weapon){
                if (item.damage > 0){
                    bestWeapon = item;
                }
                if (item.damage > bestWeapon.damage){
                    bestWeapon = item;
                }
            }
        }
        return bestWeapon;
    }

    public Items mostDefence(){
        Items bestDefence = new Items();
        for (Items item: this.inventory){
            if (item instanceof Defensive){
                if (item.defence > 0){
                    bestDefence = item;
                }
                if (item.defence > bestDefence.defence){
                    bestDefence = item;
                }
            }
        }
        return bestDefence;
    }

    public void heal(){
        // TODO: Add implementation
    }
}
