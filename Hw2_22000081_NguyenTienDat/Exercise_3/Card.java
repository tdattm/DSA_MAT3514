package Hw2_22000081_NguyenTienDat.Exercise_3;
import java.util.Arrays;
import java.util.Comparator;

public class Card implements Comparable<Card> {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card other) {
        String[] ranksOrder = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int rankComparison = Integer.compare(Arrays.asList(ranksOrder).indexOf(this.rank), Arrays.asList(ranksOrder).indexOf(other.rank));
        if (rankComparison != 0) {
            return rankComparison;
        }
        return this.suit.compareTo(other.suit);
    }

    public static Card[] createDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        Card[] deck = new Card[52];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = new Card(rank, suit);
            }
        }
        return deck;
    }

    // Comparator to compare cards for the sorting
    public static Comparator<Card> compareCards = new Comparator<Card>() {
        @Override
        public int compare(Card c1, Card c2) {
            return c1.compareTo(c2);
        }
    };
}
