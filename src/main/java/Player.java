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

    public Card getCard(int index) {
        return this.cards.get(index);
    }

    public int handValue() {
        int total = 0;
        int acesPresent = 0;
        boolean blackjackCon1 = false;
        boolean blackjackCon2 = false;

        for (Card card : cards) {
            if (card.getRank() == Rank.ACE) {
                acesPresent++;
            }
            total += card.getValue();
        }

        if (total < 21 && acesPresent > 0) {
            for (int i = 0; i < acesPresent; i++) {
                if (total <= 11) {
                    total += 10;
                }
            }
        }

        for (Card card : cards) {
            if (card.getRank() == Rank.ACE) {
                if (card.getSuit() == Suit.CLUBS || card.getSuit() == Suit.SPADES) {
                    blackjackCon1 = true;
                }
            } else if (card.getValue() == 10 && total <= 21) {
                blackjackCon2 = true;
            }
        }

        if (blackjackCon1 == true && blackjackCon2 == true) {
            total = 9001;
        }

        return total;
    }

    public void twist(Deck deck) {
        Card card = deck.topCard();
        addCard(card);
    }
}
