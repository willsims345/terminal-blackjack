import java.util.ArrayList;

public class Player {
    ArrayList<Card> hand = new ArrayList<Card>();
    int handTotal;
    int funds;

    Player(){}

    public String hit(Card c) {
        hand.add(c);
        handTotal += c.value;
        if (handTotal > 21) {
            return "bust!";
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

    public static Player compareHands(Player a, Player b) {
        if (a.handTotal > b.handTotal) {
            return a;
        } else if (b.handTotal > a.handTotal) {
            return b;
        } else {
            return null;
        }
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

    public void reset() {
        hand.clear();
        handTotal = 0;
    }
}
