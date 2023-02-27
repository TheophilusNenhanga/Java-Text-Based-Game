package SuperClasses;
import NPC.NonPlayerCharacter;
import Player.Player;
import java.util.Scanner;

public interface TradeTiles {

    Scanner scanner = new Scanner(System.in);
    default void checkIfTrade(Player player, NonPlayerCharacter trader) {
        while (true){
            System.out.println("Would you like to (B)uy or (Q)uit?");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("q")){
                return;
            } else if (userInput.equalsIgnoreCase("b")) {
                System.out.println("---Buying from the Trader---");
                this.trade(player, trader);
            }else{
                System.out.println("---Invalid Choice---");
            }
        }
    }

    void trade(Player buyer, NonPlayerCharacter seller);

    void swap(NonPlayerCharacter seller, Player buyer, Items itemToSwap);

}
