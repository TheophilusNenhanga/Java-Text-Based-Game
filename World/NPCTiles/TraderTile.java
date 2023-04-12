package World.NPCTiles;

import Consumable.Consumable;
import NPC.NonPlayerCharacter;
import NPC.Trader;
import Player.Player;
import SuperClasses.Items;
import SuperClasses.TradeTiles;
import World.MapTile;

public class TraderTile extends MapTile implements TradeTiles {
    public Trader trader;
    public TraderTile(int x, int y){
        super(x, y);
        this.trader = new Trader();
    }

    @Override
    public void introText() {
        System.out.println(
                """
                        A frail not-quite human, not-quite creature squats in the corner.
                        Clinking his gold coins together. He looks ready to trade.
                        Will you tke the risk?
                        """);
    }

    @Override
    public void trade(Player buyer, NonPlayerCharacter seller) {
        for (int i = 0; i < seller.inventory.size(); i++){
            System.out.printf("%d. %s - %d Gold\n", i+1, ((Consumable) seller.inventory.get(i)).name, ((Consumable) seller.inventory.get(i)).value);
        }
        System.out.printf("---You have %d Gold---\n", buyer.gold);
        while (true){
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("q")){
                return;
            }else{
                try{
                    int userChoice = Integer.parseInt(userInput);
                    Consumable toSwap = (Consumable) seller.inventory.get(userChoice - 1);
                    this.swap(seller, buyer, toSwap);
                }catch (RuntimeException e){
                    System.out.println("---Error: Failed to trade---");
                }
            }
        }
    }

    @Override
    public void swap(NonPlayerCharacter seller, Player buyer, Items itemToSwap) {
        if (((Consumable) itemToSwap).value > buyer.gold){
            System.out.println("---Too expensive---");
            return;
        }
        seller.inventory.remove(itemToSwap);
        buyer.inventory.add(itemToSwap);
        seller.gold += ((Consumable) itemToSwap).value;
        buyer.gold -= ((Consumable) itemToSwap).value;
        System.out.println("---Trade Completed---");
    }
}
