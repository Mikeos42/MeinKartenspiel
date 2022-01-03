package spielDateien;

import java.util.*;
import java.util.stream.Collectors;

public class Deck {
    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }
    public Deck(List<Card> deck) {
        this.deck = new ArrayList<>(deck);
    }

    public void addCard(Card card) {
        deck.add(card);
    }
    public void addCards(List<Card> cards) {
        deck.addAll(List.copyOf(cards));
    }

    public void removeCard(Card card) {
        deck.remove(card);
    }
    public void removeCards(Card card) {
        deck = deck.stream().filter(x -> !card.equals(x)).collect(Collectors.toList());
    }
    public void removeCards(Card[] cards) {
        for(Card el : cards) {
            deck = deck.stream().filter(x -> !el.equals(x)).collect(Collectors.toList());
        }
    }
    public void removeCards(List<Card> cards) {
        cards.forEach(x -> {
            deck = deck.stream().filter(y -> !x.equals(y)).collect(Collectors.toList());
        });
    }

    public Card poll() {
        if (deck.isEmpty()) throw new RuntimeException("No more cards to poll");
        Card ret = new Card(deck.get(deck.size() - 1));
        deck.remove(deck.size() - 1);
        return ret;
    }
    public List<Card> poll(int n) {
        if(deck.size() < n) throw new RuntimeException("Not enough cards to poll");
        List<Card> ret = new ArrayList<>();
        while (n != 0) {
            ret.add(poll());
            n--;
        }
        return ret;
    }

    public void clearDeck() {
        deck.clear();
    }
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public List<Card> getDeck() {
        return new ArrayList<>(deck);
    }

    public int getSum() {
        return deck.stream().mapToInt(x -> x.getType().getVal()).sum();
    }

    @Override
    public String toString() {
        return deck.toString();
    }

    public static Deck getDefaultDeck() {
        List<Card> ret = new ArrayList<>();
        for(Card.Type t : Card.Type.values_normal()) {
            for(Card.Suit s : Card.Suit.values_normal()) {
                ret.add(new Card(t, s));
            }
        }
        ret.add(new Card(Card.Type.JOKER, Card.Suit.JOKER_BLACK));
        ret.add(new Card(Card.Type.JOKER, Card.Suit.JOKER_RED));

        return new Deck(ret);
    }
    public static Deck getSmallDeck() {
        return getSmallDeck(Card.Type.TWO, Card.Type.JOKER);
    }
    public static Deck getSmallDeck(Card.Type start, Card.Type end) {
        List<Card> ret = new ArrayList<>();
        for (Card.Type t : Card.Type.values_normal()) {
            for (Card.Suit s : Card.Suit.values_normal()) {
                if (t.getVal() >= start.getVal() && t.getVal() <= end.getVal()) {
                    ret.add(new Card(t, s));
                }
            }
        }
        if (end.getVal() == Card.Type.JOKER.getVal()) {
            ret.add(new Card(Card.Type.JOKER, Card.Suit.JOKER_BLACK));
            ret.add(new Card(Card.Type.JOKER, Card.Suit.JOKER_RED));
        }
        return new Deck(ret);
    }
}
