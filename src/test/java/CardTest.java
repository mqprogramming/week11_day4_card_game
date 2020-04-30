import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card card;

    @Before
    public void before(){
        card = new Card(Suit.CLUBS,Rank.QUEEN);
    }

    @Test
    public void canGetSuit(){
        assertEquals(Suit.CLUBS,card.getSuit());
    }

    @Test
    public void canGetRank(){
        assertEquals(Rank.QUEEN,card.getRank());
    }

    @Test
    public void canGetValueFromCard(){
        assertEquals(10,card.getValue());
    }

}
