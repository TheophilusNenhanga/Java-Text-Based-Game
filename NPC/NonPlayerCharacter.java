package NPC;

import Consumable.*;
import Defensive.*;
import SuperClasses.Items;
import Weapon.*;

import java.util.ArrayList;
import java.util.Random;

public class NonPlayerCharacter {
    public ArrayList<Items> allItems = new ArrayList<>();

    public String name;
    public int gold;
    public static final Random random = new Random();
    public ArrayList<Items> inventory = new ArrayList<>();

    public NonPlayerCharacter() {
        this.allItems.add(new SnakeApple());
        this.allItems.add(new RottenFlesh());
        this.allItems.add(new CrustyBread());
        this.allItems.add(new Apple());
        this.allItems.add(new FreshBread());
        this.allItems.add(new CookedInsectFlesh());
        this.allItems.add(new HealingPotion());
        this.allItems.add(new StrongHealingPotion());
        this.allItems.add(new HyperHealingPotion());
        this.allItems.add(new LuckyFruit());
        this.allItems.add(new WoodenShield());
        this.allItems.add(new DefensiveClothing());
        this.allItems.add(new MetalShield());
        this.allItems.add(new ChainMail());
        this.allItems.add(new MetalArmour());
        this.allItems.add(new ReinforcedMetalArmour());
        this.allItems.add(new ShinySword());
        this.allItems.add(new LightSaber());
        this.allItems.add(new HeavySaber());
        this.allItems.add(new BattleAxe());
        this.allItems.add(new Mace());
        this.allItems.add(new SharpSpear());
        this.allItems.add(new BowAndArrow());
        this.allItems.add(new WoodenClub());
        this.allItems.add(new MetalClub());
        this.allItems.add(new Pike());
        this.allItems.add(new BluntSpear());
        this.allItems.add(new Excalibur());
    }
}
