import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DealerTest {

    private Dealer dealer;
    private Deck deck;

    @Before
    public void before() {
        deck = new Deck();
        dealer = new Dealer();

        deck.populate();
        deck.shuffle();
    }

    @Test
    public void dealerStartsWithNoCards() {
        assertEquals(0, dealer.cardsCount() );
    }

    @Test
    public void canDealerBeDealtCards() {
        dealer.twist(deck);
        assertEquals(1, dealer.cardsCount() );
    }

    @Test
    public void doesDealerGameLogicWork() {
        dealer.playRound(deck);
        assertTrue(dealer.handValue() > 15);
        assertTrue(dealer.cardsCount() > 1);
    }

}
