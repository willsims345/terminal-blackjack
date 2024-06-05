public class Card {
    char rank;
    String suit;
    Card(char rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return this.rank + " of " + this.suit + "s";
    }
}
