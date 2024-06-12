import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardDrawer {

    public static void main(String[] args) {
        Deck deck = new Deck();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Card Drawerer");

        try {
            boolean quit = false;
            while(!quit) {
                String input = reader.readLine();
                switch(input) {
                    case "d":
                        System.out.println(deck.draw());
                        break;
                    case "s":
                        System.out.print("Shuffling...\n");
                        deck.shuffle();
                        break;
                    case "q":
                        quit = true;
                        break;
                    default:
                        System.out.println("Please enter a valid command");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
    }
}
