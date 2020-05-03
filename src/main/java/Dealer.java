import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.HashMap;

public class Dealer extends Player {

    public ArrayList<Player> compareHands(HashMap<String, Player> participants) {
        ArrayList<Player> winners = new ArrayList<Player>();
        Player dealer = participants.remove("Dealer");

        for (Player player : participants.values()) {
            if (dealer.handValue() != 9001) {
                if (player.handValue() == 9001) {
                    winners.add(player);
                } else if (player.handValue() > dealer.handValue() && player.handValue() <= 21) {
                    winners.add(player);
                } else if (player.handValue() <= 21 && dealer.handValue() > 21) {
                    winners.add(player);
                }
            }
        }

        if (winners.size() == 0) {
            winners.add(dealer);
        }

        return winners;
    }

    public void playRound(Deck deck) {
        twist(deck);
        twist(deck);
        while (handValue() < 16) {
            twist(deck);
        }
    }
}
