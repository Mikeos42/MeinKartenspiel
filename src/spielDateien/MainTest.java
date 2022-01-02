package spielDateien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        Deck deck = Deck.getSmallDeck(Card.Type.NINE, Card.Type.ACE);
        Deck player = new Deck();
        Deck computer = new Deck();
        Deck table = new Deck();

        deck.shuffleDeck();

        player.addCards(deck.poll(2));
        computer.addCards(deck.poll(2));

        System.out.println("player = " + player);
        System.out.println("computer = " + computer);

        table.addCards(deck.poll(5));

        System.out.println("table = " + table);
    }
}
