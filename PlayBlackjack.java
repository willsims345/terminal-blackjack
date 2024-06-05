import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayBlackjack {

    public static void playGame(BufferedReader reader) {
        Deck gameDeck = new Deck();
        boolean quit = false;

        System.out.println("\nPlease type one of the following commands");
        System.out.println("- shuffle");
        System.out.println("- draw");
        System.out.println("- quit\n");
        try{
            while(!quit) {
                System.out.print("Command: ");
                String command = reader.readLine();

                switch(command) {
                    case "shuffle":
                        System.out.println("Shuffling cards...\n");
                        gameDeck.shuffle();
                        break;
                    case "draw":
                        System.out.println("Drawing top card...\n");
                        System.out.println(gameDeck.draw());
                        break;
                    case "quit":
                        System.out.println("Quitting game...\n");
                        quit = true;
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number for age.");
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to Terminal Balckjack");
        System.out.println("1. Start New Game");
        System.out.println("2. Help");
        System.out.println("3. Exit\n");
        System.out.print("Please enter your choice (1-5): ");
        try {
            // Read the initial command
            String command = reader.readLine();

            int choice = Integer.parseInt(command);
            
            switch(choice) {
                case 1:
                    System.out.println("\nStarting new blackjack game...");
                    playGame(reader);
                    break;
                case 2:
                    System.out.println("\nDisplaying help...");
                    break;
                case 3:
                    System.out.println("\nExiting...");
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number for age.");
        }
    }
}