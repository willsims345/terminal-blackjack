public class Card {
    char rank;
    String suit;
    int value;

    String card = "";

    Card(char rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        switch(suit) {
            case "spade":
                card = buildSpade();
                break;
            case "club":
                card = buildClub();
                break;
            case "heart":
                card = buildHeart();
                break;
            case "diamond":
                card = buildDiamond();
                break;
        }
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
        String sixthRow = "|____" + rank + "|\n";
        return firstRow + secondRow + thirdRow + fourthRow + fifthRow + sixthRow;
    }

    public String buildClub() {
        String firstRow = " _____ \n";
        String secondRow = "|" + rank + " .  |\n";
        String thirdRow = "| ( ) |\n";
        String fourthRow = "|(_'_)|\n";
        String fifthRow = "|  |  |\n";
        String sixthRow = "|____" + rank + "|\n";
        return firstRow + secondRow + thirdRow + fourthRow + fifthRow + sixthRow;
    }

    public String buildHeart() {
        String firstRow = " _____ \n";
        String secondRow = "|" + rank + "_ _ |\n";
        String thirdRow = "|( v )|\n";
        String fourthRow = "| \\ / |\n";
        String fifthRow = "|  .  |\n";
        String sixthRow = "|____" + rank + "|\n";
        return firstRow + secondRow + thirdRow + fourthRow + fifthRow + sixthRow;
    }

    public String buildDiamond() {
        String firstRow = " _____ \n";
        String secondRow = "|" + rank + " ^  |\n";
        String thirdRow = "| / \\ |\n";
        String fourthRow = "| \\ / |\n";
        String fifthRow = "|  .  |\n";
        String sixthRow = "|____" + rank + "|\n";
        return firstRow + secondRow + thirdRow + fourthRow + fifthRow + sixthRow;
    }

    public String toString() {
        return card;
        //return this.rank + " of " + this.suit + "s";
    }
}
