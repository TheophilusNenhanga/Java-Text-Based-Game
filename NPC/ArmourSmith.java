package NPC;

import Consumable.*;
import Defensive.Defensive;
import SuperClasses.Items;

import java.util.ArrayList;

public class ArmourSmith extends NonPlayerCharacter{
    public ArmourSmith(){
        super();
        this.name =  "Armour Smith";
        this.gold = random.nextInt(200, 250);
        for (Items item: this.allItems){
            if (item instanceof Defensive){
                this.inventory.add(item);
            }
        }
    }
}