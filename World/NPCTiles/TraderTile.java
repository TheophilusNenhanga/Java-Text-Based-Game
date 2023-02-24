package World.NPCTiles;

import Consumable.Consumable;
import NPC.Trader;
import Player.Player;
import SuperClasses.Items;
import World.MapTile;

public class TraderTile extends MapTile {
    Trader trader;
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

    public void trade(Player buyer, Trader seller){
        //TODO: Add implementation - trading with the NPC
        for (int i = 0; i < seller.inventory.size(); i++){
            System.out.printf("%d. %s - %d Gold\n", i, seller.inventory.get(i).name, seller.inventory.get(i).value);
        }
        while (true){
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("q")){
                return;
            }else{
                try{
                    int userChoice = Integer.parseInt(userInput);
                    Consumable toSwap = seller.inventory.get(userChoice - 1);
                    this.swap(seller, buyer, toSwap);
                }catch (RuntimeException e){
                    System.out.println("---Error: Failed to trade---");
                }
            }
        }
    }



    public void swap(Trader seller, Player buyer, Consumable itemToSwap){
        if (itemToSwap.value > buyer.gold){
            System.out.println("---Too expensive---");
            return;
        }
        seller.inventory.remove(itemToSwap);
        buyer.inventory.add(itemToSwap);
        seller.gold += itemToSwap.value;
        buyer.gold -= itemToSwap.value;
        System.out.println("---Trade Completed---");
    }

    public void checkIfTrade(Player player){
        while (true){
            System.out.println("Would you like to (B)uy or (Q)uit?");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("q")){
                return;
            } else if (userInput.equalsIgnoreCase("b")) {
                System.out.println("---Buying from the Trader---");
                this.trade(player, this.trader);
            }else{
                System.out.println("---Invalid Choice---");
            }
        }
    }
}
