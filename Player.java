import java.util.ArrayList;

public class Player {
    ArrayList<Card> hand = new ArrayList<Card>();
    int handTotal;
    int funds;

    Player(){}

    public void addCard(Card c) {
        hand.add(c);
        handTotal += c.value;
    }

    public int bet(int ammount) {
        funds -= ammount;
        return ammount;
    }

    public String viewHand() {
        String handString = "";
        for(int i = 0; i < hand.size(); i++) {
            handString += hand.get(i).toString();
        }
        return handString;
    }
}
