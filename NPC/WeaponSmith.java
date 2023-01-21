package NPC;

import SuperClasses.Items;
import Weapon.Weapon;

import java.util.ArrayList;

public class WeaponSmith extends NonPlayerCharacter{
    ArrayList<Items> inventory = new ArrayList<>();
    public WeaponSmith(){
        super();
        this.name =  "Weapon Smith";
        this.gold = random.nextInt(200, 250);
        for (Items item: this.allItems){
            if (item instanceof Weapon){
                this.inventory.add(item);
            }
        }
    }
}