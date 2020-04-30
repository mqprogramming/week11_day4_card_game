import java.util.ArrayList;

public class Player {

    private ArrayList<Card> cards;

    public Player() {
        cards = new ArrayList<Card>();
    }

    public void addCard(Card takenCard) {
        this.cards.add(takenCard);
    }

    public int cardsCount() {
        return this.cards.size();
    }

    public Card getCard() {
        return this.cards.get(0);
    }
}
