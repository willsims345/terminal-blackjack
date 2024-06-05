public class Card {
    char rank;
    String suit;
    int value;

    String card = "";

    Card(char rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        card = buildSpade();
        if(rank < 58) {
            value = rank - 48;
        } else if (rank == 'A') {
            value = 11;
        } else {
            value = 10;
        }
    }

    public String buildSpade() {
        String firstRow = " _____ \n";
        String secondRow = "|" + rank + " .  |\n";
        String thirdRow = "| /.\\ |\n";
        String fourthRow = "|(_._)|\n";
        String fifthRow = "|  |  |\n";
        String sixthRow = "|    " + rank + "|\n";
        String seventhRow = "|_____|\n";
        return firstRow + secondRow + thirdRow + fourthRow + fifthRow + sixthRow + seventhRow;
    }

    public String toString() {
        return card;
        //return this.rank + " of " + this.suit + "s";
    }
}
