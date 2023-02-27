package NPC;

import Consumable.*;
import SuperClasses.Items;

import java.util.ArrayList;

public class Trader extends NonPlayerCharacter{
    public Trader(){
        super();
        this.name =  "Trader";
        this.gold = random.nextInt(200, 250);
        for (Items item: this.allItems){
            if (item instanceof Consumable){
                this.inventory.add((Consumable) item);
            }
        }
    }
}
