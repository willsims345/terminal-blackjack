import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayBlackjack {

    public static void showState(Player player, Player dealer) {
        System.out.println("Your hand: " + player.viewHand());
        System.out.println("Dealer showing: " + dealer.dealerShowing());
    }

    public static void playGame(BufferedReader reader) {
        Deck gameDeck = new Deck();
        boolean quit = false;
        Player dealer = new Player();
        Player player = new Player();

        System.out.println("_________________________________________");

        System.out.println("\nNew game started! Shuffling cards...");
        gameDeck.shuffle();

        System.out.println("\nPlease type one of the following commands");
        System.out.println("- h (hit)");
        try{
            while(!quit) {
                System.out.println("\nBet ammount: ");
                int ammount = Integer.parseInt(reader.readLine()); // add try catch block later
                player.bet(ammount);

                player.hit(gameDeck.draw());
                dealer.hit(gameDeck.draw());
                player.hit(gameDeck.draw());
                dealer.hit(gameDeck.draw());

                showState(player, dealer);

                System.out.print("\nCommand: ");
                String command = reader.readLine();

                switch(command) {
                    case "h":
                        System.out.println(player.hit(gameDeck.draw()));
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

    public static String generateTitle() {
        StringBuilder art = new StringBuilder();
        
        art.append("  _______                  _             _   ____  _            _    _            _    \n");
        art.append(" |__   __|                (_)           | | |  _ \\| |          | |  (_)          | |   \n");
        art.append("    | | ___ _ __ _ __ ___  _ _ __   __ _| | | |_) | | __ _  ___| | ___  __ _  ___| | __\n");
        art.append("    | |/ _ \\ '__| '_ ` _ \\| | '_ \\ / _` | | |  _ <| |/ _` |/ __| |/ / |/ _` |/ __| |/ /\n");
        art.append("    | |  __/ |  | | | | | | | | | | (_| | | | |_) | | (_| | (__|   <| | (_| | (__|   < \n");
        art.append("    |_|\\___|_|  |_| |_| |_|_|_| |_|\\__,_|_| |____/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\n");
        art.append("                                                                   _/ |                \n");
        art.append("                                                                  |__/                 \n");
        
        return art.toString();
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(generateTitle());

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