package spielDateien;

import java.util.Scanner;

public class Game {
    public void blackJack() {
        Deck deck = Deck.getDefaultDeck();
        deck.shuffleDeck();
        Deck player = new Deck();
        Deck computer = new Deck();

        player.addCard(deck.poll());
        computer.addCard(deck.poll());

        while (true) {
            System.out.println(player + " = " + player.getSum());
            if(player.getSum() > 21) break;
            System.out.println("Take another? Y/N");
            Scanner takeAnother = new Scanner(System.in);
            if(takeAnother.nextLine().equalsIgnoreCase("n")) break;
            else player.addCard(deck.poll());
        }

        System.out.println("Play again? Y/N");

        Scanner userInput = new Scanner(System.in);
        String next = userInput.nextLine();
        if(next.toLowerCase() == "y") {
            blackJack();
        }
    }
}
