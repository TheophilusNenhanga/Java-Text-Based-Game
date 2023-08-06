package Player;

import Consumable.Consumable;
import Consumable.CrustyBread;
import Defensive.Defensive;
import Enemy.Enemy;
import NPC.StoryTeller;
import SuperClasses.Items;
import Weapon.*;
import World.EnemyTiles.EnemyTile;
import World.NPCTiles.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static Game.Game.world;


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
    private static final Scanner scanner = new Scanner(System.in);

    public Player(int x, int y) {
        this.victory = false;
        this.kindness = false;
        this.inventory = new ArrayList<>();
        this.x = x;
        this.y = y;
        this.gold = 25;
        this.crystals = 5;
        this.name = "";
        this.hp = 100;
        this.score = 0;
        this.boss = 0;

        this.inventory.add(new Hand());
        this.inventory.add(new CrustyBread());
        this.inventory.add(new RustySword());
    }

    public void attack(EnemyTile room) {

        Enemy enemy = room.enemy;

        if (!enemy.isAlive()) {
            return;
        }

        double defenceMultiplier = 0.1 * enemy.defence;
        double attackMultiplier = 1;
        Weapon bestWeapon = this.mostDamage();
        int damageDealt = (int) ((bestWeapon.damage * attackMultiplier) - (bestWeapon.damage * defenceMultiplier));
        enemy.hp = enemy.hp - damageDealt;
        System.out.printf("You deal %d damage\n", damageDealt);

        if (!enemy.isAlive() && !room.completed) {
            System.out.printf("You killed the %s\n", enemy.name);
            this.gold += enemy.reward;
            System.out.printf("You receive +%d gold.\n", enemy.reward);
            this.score += enemy.score;
            int amount = random.nextInt(0, 2);
            if (amount != 0) {
                this.crystals += amount;
                System.out.printf("You receive +%d crystals\n\n", amount);
            }
        } else {
            System.out.printf("The %s has %d health remaining\n\n", enemy.name, enemy.hp);
        }
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void moveNorth() {
        this.move(0, -1);
    }

    public void moveEast() {
        this.move(1, 0);
    }

    public void moveSouth() {
        this.move(0, 1);
    }

    public void moveWest() {
        this.move(-1, 0);
    }

    public Weapon mostDamage() {
        Weapon bestWeapon = new Hand();
        for (Items items : this.inventory) {
            try {
                Weapon currentWeapon = (Weapon) items;
                if (currentWeapon.damage > bestWeapon.damage) {
                    bestWeapon = currentWeapon;
                }
            } catch (RuntimeException ignored) {
            }
        }
        return bestWeapon;
    }

    public Defensive mostDefence() {
        return null;
    }

    public void heal() {
        ArrayList<Consumable> consumables = new ArrayList<>();
        for (Items item : this.inventory) {
            if (item instanceof Consumable) {
                consumables.add((Consumable) item);
            }
        }
        if (consumables.size() == 0) {
            System.out.println("---You do not have any items to heal you---\n");
            return;
        }
        System.out.println("Choose a healing item: ");
        for (int i = 0; i < consumables.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, consumables.get(i));
        }
        while (!(this.hp >= 100)) {
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("q")) {
                return;
            } else {
                try {
                    int userChoice = Integer.parseInt(userInput);
                    Consumable toEat = consumables.get(userChoice - 1);
                    this.inventory.remove(toEat);
                    this.hp = Math.round(Math.min(100, this.hp + toEat.healingValue));
                    System.out.println("Current HP: " + this.hp + "\n");
                    return;
                } catch (RuntimeException e) {
                    System.out.println("---Invalid Choice Error: Failed to heal---");
                }
            }
        }
    }

    public void converse() {
        StoryTellerTile room = (StoryTellerTile) world.getTile(this.x, this.y);
        room.beginConversation(this, (StoryTeller) room.npc);

    }

    public void trade() {
        TraderTile room = (TraderTile) world.getTile(this.x, this.y);
        room.checkIfTrade(this, room.trader);
    }

    public void tradeArmour() {
        ArmourSmithTile room = (ArmourSmithTile) world.getTile(this.x, this.y);
        room.checkIfTrade(this, room.trader);
    }

    public void tradeWeapon() {
        WeaponSmithTile room = (WeaponSmithTile) world.getTile(this.x, this.y);
        room.checkIfTrade(this, room.trader);
    }

    public void enchant() {
        EnchanterTile room = (EnchanterTile) world.getTile(this.x, this.y);
        room.checkIfTrade(this, room.enchanter);
    }

    public boolean hasName() {
        return !this.name.isEmpty();
    }
}
