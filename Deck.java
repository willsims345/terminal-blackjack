import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    Card[] deck = {
        new Card('2', "spade"),
        new Card('3', "spade"),
        new Card('4', "spade"),
        new Card('5', "spade"),
        new Card('6', "spade"),
        new Card('7', "spade"),
        new Card('8', "spade"),
        new Card('9', "spade"),
        new Card('T', "spade"),
        new Card('J', "spade"),
        new Card('Q', "spade"),
        new Card('K', "spade"),
        new Card('A', "spade"),
        new Card('2', "club"),
        new Card('3', "club"),
        new Card('4', "club"),
        new Card('5', "club"),
        new Card('6', "club"),
        new Card('7', "club"),
        new Card('8', "club"),
        new Card('9', "club"),
        new Card('T', "club"),
        new Card('J', "club"),
        new Card('Q', "club"),
        new Card('K', "club"),
        new Card('A', "club"),
        new Card('2', "diamond"),
        new Card('3', "diamond"),
        new Card('4', "diamond"),
        new Card('5', "diamond"),
        new Card('6', "diamond"),
        new Card('7', "diamond"),
        new Card('8', "diamond"),
        new Card('9', "diamond"),
        new Card('T', "diamond"),
        new Card('J', "diamond"),
        new Card('Q', "diamond"),
        new Card('K', "diamond"),
        new Card('A', "diamond"),
        new Card('2', "heart"),
        new Card('3', "heart"),
        new Card('4', "heart"),
        new Card('5', "heart"),
        new Card('6', "heart"),
        new Card('7', "heart"),
        new Card('8', "heart"),
        new Card('9', "heart"),
        new Card('T', "heart"),
        new Card('J', "heart"),
        new Card('Q', "heart"),
        new Card('K', "heart"),
        new Card('A', "heart")
    };

    int currPos = 0;

    Deck(){}

    public void shuffle() {
        List<Card> cardList = Arrays.asList(this.deck);
        Collections.shuffle(cardList);
        cardList.toArray(this.deck);
        currPos = 0;
    }

    public Card draw() {
        Card topCard = deck[currPos];
        currPos++;
        return topCard;
    }

}
