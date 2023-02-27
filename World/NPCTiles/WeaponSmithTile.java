package World.NPCTiles;

import Defensive.Defensive;
import NPC.NonPlayerCharacter;
import NPC.WeaponSmith;
import Player.Player;
import SuperClasses.Items;
import SuperClasses.TradeTiles;
import Weapon.Weapon;
import World.MapTile;

public class WeaponSmithTile extends MapTile implements TradeTiles {
    public WeaponSmith trader;
    public WeaponSmithTile(int x, int y){
        super(x, y);
        this.trader = new WeaponSmith();
    }

    @Override
    public void introText() {
        System.out.println(
                """
                        A frail not-quite human, not-quite creature squats in the corner.
                        Clinking his gold coins together. He looks ready to trade.
                        """
        );
    }
    public void trade(Player buyer, NonPlayerCharacter seller) {
        for (int i = 0; i < seller.inventory.size(); i++){
            System.out.printf("%d. %s - %d Gold\n", i+1, ((Weapon) seller.inventory.get(i)).name, ((Weapon) seller.inventory.get(i)).value);
        }
        while (true){
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("q")){
                return;
            }else{
                try{
                    int userChoice = Integer.parseInt(userInput);
                    Weapon toSwap = (Weapon) seller.inventory.get(userChoice - 1);
                    this.swap(seller, buyer, toSwap);
                }catch (RuntimeException e){
                    System.out.println("---Error: Failed to trade---");
                }
            }
        }
    }

    @Override
    public void swap(NonPlayerCharacter seller, Player buyer, Items itemToSwap) {
        if (((Weapon) itemToSwap).value > buyer.gold){
            System.out.println("---Too expensive---");
            return;
        }
        seller.inventory.remove(itemToSwap);
        buyer.inventory.add(itemToSwap);
        seller.gold += ((Weapon) itemToSwap).value;
        buyer.gold -= ((Weapon) itemToSwap).value;
        System.out.println("---Trade Completed---");
    }
}