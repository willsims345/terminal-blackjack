import java.util.ArrayList;

public class Player {
    ArrayList<Card> hand = new ArrayList<Card>();
    int handTotal;
    int funds;

    Player(){}

    // handle if the player has an ace and that ace needs to be a 1 or an 11
    public void hasAce() {
        for(int i = 0; i < hand.size(); i++) {
            Card currCard = hand.get(i);
            if(currCard.rank == 'A' && !currCard.aceAsOne) {
                currCard.aceAsOne = true;
                handTotal = handTotal - 10;
                break;
            }
        }
    }

    public String hit(Card c) {
        hand.add(c); // add card to hand
        handTotal += c.value; // adjust the hand total
        if (handTotal > 21) {
            hasAce(); // see if any of the current cards are aces and if they are make their value 1
            if(handTotal > 21) { // if the hand total is STILL greater than 21 then the player has busted;
                return "bust!";
            }
            return "";
        } else {
            return "";
        }
    }

    public int bet(int ammount) {
        funds -= ammount;
        return ammount;
    }

    public int addWin(int amount) {
        funds += amount;
        return funds;
    }

    public String viewHand() {
        String handString = "";
        for(int i = 0; i < hand.size(); i++) {
            if (i == hand.size() - 1) {
                handString += hand.get(i).toString();
            } else {
                handString += hand.get(i).toString() + ", ";
            }
        }
        return handString;
    }

    public String dealerShowing() {
        if (hand.size() > 1) {
            return hand.get(1).toString();
        }
        return "The wrong ammount of cards in hand for this operation";
        
    }

    // reset the players hand and handTotal
    public void reset() {
        hand.clear();
        handTotal = 0;
    }
}
