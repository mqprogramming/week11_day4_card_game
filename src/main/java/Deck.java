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

    public void deal(Player player) {
        Card takenCard = this.cards.remove(0);
        System.out.println(takenCard);
        player.addCard(takenCard);
    }

    public Player findWinner(Player player1, Player player2) {
        if(player1.getCard().getValue() >= player2.getCard().getValue()){
            return player1;
        }else{
            return player2;
        }
    }
}
