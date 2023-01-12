package Player;

import Consumables.CrustyBread;
import Defensive.Defensive;
import Enemies.Enemies;
import SuperClasses.Items;
import Weapon.Hand;
import Weapon.RustySword;
import Weapon.Weapon;
import Game.Game;
import World.MapTile;

import java.util.ArrayList;
import java.util.Objects;


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

    private void fight(Items bestWeapon, Enemies enemy){

    }

    public void attack() {

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

    }

    public boolean hasName(){
        return !this.name.equals("");
    }
}
