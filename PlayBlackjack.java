import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayBlackjack {

    public static void playGame(BufferedReader reader) {
        Deck gameDeck = new Deck();
        boolean quit = false;

        System.out.println("_________________________________________");

        System.out.println("\nPlease type one of the following commands");
        System.out.println("- s (shuffle)");
        System.out.println("- d (draw)");
        System.out.println("- q (quit)");
        try{
            while(!quit) {
                System.out.print("\nCommand: ");
                String command = reader.readLine();

                switch(command) {
                    case "s":
                        System.out.println("Shuffling cards...");
                        gameDeck.shuffle();
                        break;
                    case "d":
                        System.out.println("Drawing top card...\n");
                        System.out.println(gameDeck.draw());
                        break;
                    case "q":
                        System.out.println("Quitting game...\n");
                        quit = true;
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to Terminal Balckjack");
        System.out.println("1. Start New Game");
        System.out.println("2. Help");
        System.out.println("3. Exit\n");
        System.out.print("Please enter your choice (1-3): ");
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
        }
    }
}