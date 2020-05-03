import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeckTest {

    private Deck deck;
    private Player player1,player2;

    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player();
        player2 = new Player();
    }

    @Test
    public void deckStartFromEmpty(){
        assertEquals(0,deck.numberOfCards());
    }

    @Test
    public void canPopulateDeck(){
        deck.populate();
        assertEquals(52,deck.numberOfCards());
    }

    @Test
    public void canShuffleDeck(){
        ArrayList<Card> orginalCards = deck.populate();
        String original = orginalCards.toString();
        ArrayList<Card> shuffledCards = deck.shuffle();
        String shuffled = shuffledCards.toString();
 //       System.out.println(shuffledCards.get(0).getValue());
        assertTrue(original != shuffled);
    }

    @Test
    public void canDealACard(){
        deck.populate();
        deck.shuffle();
        player1.twist(deck);
        assertEquals(1,player1.cardsCount());
    }

}
