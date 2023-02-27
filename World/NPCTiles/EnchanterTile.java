package World.NPCTiles;

import Enchantment.Enchantment;
import NPC.Enchanter;
import NPC.NonPlayerCharacter;
import Player.Player;
import SuperClasses.Items;
import SuperClasses.TradeTiles;
import Weapon.Weapon;
import World.MapTile;

public class EnchanterTile extends MapTile implements TradeTiles {

    public Enchanter enchanter;
    public EnchanterTile(int x, int y) {
        super(x, y);
        this.enchanter = new Enchanter();
    }

    @Override
    public void trade(Player buyer, NonPlayerCharacter seller) {
        for (int i = 0; i < seller.inventory.size(); i++){
            System.out.printf("%d. %s - %d Gold\n", i+1, ((Enchantment) seller.inventory.get(i)).name, ((Enchantment) seller.inventory.get(i)).value);
        }
        while (true){
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("q")){
                return;
            }else{
                try{
                    int userChoice = Integer.parseInt(userInput);
                    Enchantment toSwap = (Enchantment) seller.inventory.get(userChoice - 1);
                    this.swap(seller, buyer, toSwap);
                }catch (RuntimeException e){
                    System.out.println("---Error: Failed to enchant---");
                }
            }
        }
    }

    @Override
    public void swap(NonPlayerCharacter seller, Player buyer, Items itemToSwap) {
        if (((Enchantment) itemToSwap).value > buyer.gold){
            System.out.println("---Too expensive---");
            return;
        }
        System.out.println("Which item would you like to enchant:");
        for (int i = 0; i < buyer.inventory.size(); i++){
            if (buyer.inventory.get(i) instanceof Weapon){
                System.out.printf("%d. %s\n", i+1, buyer.inventory.get(i));
            }
        }
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("q")) {
            return;
        }
        try{
            int userChoice = Integer.parseInt(userInput);
            ((Weapon) buyer.inventory.get(userChoice-1)).enchantment = (Enchantment) itemToSwap;
        }catch (RuntimeException e){
            System.out.println("---Enchantment Failed---");
        }

        seller.gold += ((Enchantment) itemToSwap).value;
        buyer.gold -= ((Enchantment) itemToSwap).value;
        System.out.println("---Enchantment Completed---");
    }
}