public class Card {
    char rank;
    String suit;
    int value;
    Card(char rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        if(rank < 58) {
            value = rank - 48;
        } else if (rank == 'A') {
            value = 11;
        } else {
            value = 10;
        }
    }

    public String toString() {
        return this.rank + " of " + this.suit + "s";
    }
}
