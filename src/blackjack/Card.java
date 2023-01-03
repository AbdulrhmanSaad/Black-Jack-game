
package blackjack;


public class Card {
    private final int suit;
    private final  int rank;
    private final  int value;

    public Card() {
        suit=0;
        rank=0;
        value=0;
    }

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    public Card(Card obj)
    {
        this.suit=obj.suit;
        this.rank=obj.rank;
        this.value=obj.value;
    }
    public int getRank() {
        return rank;
    }
    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}
