package World.NPCTiles;

import Defensive.Defensive;
import NPC.ArmourSmith;
import NPC.NonPlayerCharacter;
import Player.Player;
import SuperClasses.Items;
import SuperClasses.TradeTiles;
import World.MapTile;


public class ArmourSmithTile extends MapTile implements TradeTiles {
    public ArmourSmith trader;
    public ArmourSmithTile(int x, int y){
        super(x, y);
        this.trader = new ArmourSmith();
    }

    @Override
    public void introText() {
        System.out.println(
                """
                        A frail not-quite human, not-quite creature squats in the corner.
                        Clinking his gold coins together. He looks ready to trade.
                        Trade only if you dare.
                        """
        );
    }



    @Override
    public void trade(Player buyer, NonPlayerCharacter seller) {
        for (int i = 0; i < seller.inventory.size(); i++){
            System.out.printf("%d. %s - %d Gold\n", i+1, ((Defensive) seller.inventory.get(i)).name, ((Defensive) seller.inventory.get(i)).value);
        }
        while (true){
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("q")){
                return;
            }else{
                try{
                    int userChoice = Integer.parseInt(userInput);
                    Defensive toSwap = (Defensive) seller.inventory.get(userChoice - 1);
                    this.swap(seller, buyer, toSwap);
                }catch (RuntimeException e){
                    System.out.println("---Error: Failed to trade---");
                }
            }
        }
    }

    @Override
    public void swap(NonPlayerCharacter seller, Player buyer, Items itemToSwap) {
        if (((Defensive) itemToSwap).value > buyer.gold){
            System.out.println("---Too expensive---");
            return;
        }
        seller.inventory.remove(itemToSwap);
        buyer.inventory.add(itemToSwap);
        seller.gold += ((Defensive) itemToSwap).value;
        buyer.gold -= ((Defensive) itemToSwap).value;
        System.out.println("---Trade Completed---");
    }
}