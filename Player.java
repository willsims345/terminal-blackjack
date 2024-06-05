import java.util.ArrayList;

public class Player {
    ArrayList<Card> hand = new ArrayList<Card>();
    int total;

    Player(){}

    public void addCard(Card c) {
        hand.add(c);
        total += c.value;
    }

    public String viewHand() {
        String handString = "";
        for(int i = 0; i < hand.size(); i++) {
            handString += hand.get(i).toString();
        }
        return handString;
    }
}
