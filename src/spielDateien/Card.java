package spielDateien;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Card {
    public enum Type {
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("Jack", 11),
        QUEEN("Queen", 12),
        KING("King", 13),
        ACE("Ace", 14),
        JOKER("Joker", 15);

        private final String name;
        private final int val;

        Type(String name, int val) {
            this.name = name;
            this.val = val;
        }

        public String getName() {
            return name;
        }

        public int getVal() {
            return val;
        }

        public static Type[] values_normal() {
            return Arrays.stream(values()).filter(x -> x.getVal() != 15).toArray(Type[]::new);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public enum Suit {
        CLUBS("clubs", Colour.BLACK, "\u001B[30m♣\u001B[0m"),
        DIAMONDS("diamonds", Colour.RED, "\u001B[31m♦\u001B[0m"),
        HEARTS("hearts", Colour.RED, "\u001B[31m♥\u001B[0m"),
        SPADES("spades", Colour.BLACK, "\u001B[30m♠\u001B[0m"),
        JOKER_BLACK("star", Colour.BLACK, "\u001B[30m⍟\u001B[0m"),
        JOKER_RED("star", Colour.RED, "\u001B[31m⍟\u001B[0m");

        private final String name;
        private final Colour col;
        private final String sym;

        Suit(String name, Colour col, String sym) {
            this.name = name;
            this.col = col;
            this.sym = sym;
        }

        public String getName() {
            return name;
        }

        public Colour getCol() {
            return col;
        }

        public String getSym() {
            return sym;
        }

        @Override
        public String toString() {
            return name;
        }

        public static Suit[] values_normal() {
            return new Suit[]{CLUBS, DIAMONDS, HEARTS, SPADES};
        }
    }

    public enum Colour {
        RED("red"),
        BLACK("black");

        private final String name;

        Colour(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private final Type type;
    private final Suit suit;

    Card(Type type, Suit suit) {
        this.type = type;
        this.suit = suit;
    }

    Card(Card other) {
        this.type = other.getType();
        this.suit = other.getSuit();
    }

    public Type getType() {
        return type;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "[" + getSuit().getSym() + " " + getType().getName() + "]";
    }

    @Override
    public boolean equals(Object other) {
        if(other.getClass() != Card.class) {
            throw new IllegalArgumentException("Object not Card!");
        }
        return ((Card) other).getType() == getType() &&
                ((Card) other).getSuit() == getSuit();
    }
}
