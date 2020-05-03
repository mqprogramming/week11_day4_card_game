import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public int numberOfCards() {
        return this.cards.size();
    }

    public ArrayList<Card> populate() {
        for ( Suit s : Suit.values() ) {
            for ( Rank r : Rank.values() ) {
                Card card = new Card(s, r);
                cards.add(card);
            }
        }
        return this.cards;
    }

    public ArrayList<Card> shuffle(){
        Collections.shuffle(this.cards);
        return this.cards;
    }

    public Card topCard() {
        Card takenCard = this.cards.remove(0);
        return takenCard;
    }

}
