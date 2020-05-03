import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class GameTest {

    private Player player1;
    private Player player2;
    private Dealer dealer;
    private HashMap<String, Player> participants;
    private Deck deck;

    @Before
    public void before() {
        player1 = new Player();
        player2 = new Player();
        dealer = new Dealer();

        participants = new HashMap<String, Player>();
        participants.put("Dealer", dealer);
        participants.put("Player 1", player1);
        participants.put("Player 2", player2);

        deck = new Deck();
        deck.populate();
        deck.shuffle();

        player1.twist(deck);
        player1.twist(deck);
        player2.twist(deck);
        player2.twist(deck);
        player2.twist(deck);
        dealer.playRound(deck);
    }

    @Test
    public void canDealerDetermineWinners() {
        ArrayList<Player> winners = dealer.compareHands(participants);
        System.out.println(dealer.handValue());
        System.out.println(player1.handValue());
        System.out.println(player2.handValue());
        System.out.println(winners);
        assertTrue(winners != null);
    }

}
