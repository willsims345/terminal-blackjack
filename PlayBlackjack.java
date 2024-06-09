import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayBlackjack {

    public static void showState(Player player, Player dealer) {
        System.out.println("Your hand: " + player.viewHand());
        System.out.println("Dealer showing: " + dealer.dealerShowing());
    }

    public static void playGame1(BufferedReader reader) {
        Deck gameDeck = new Deck();
        boolean quit = false;
        Player dealer = new Player();
        Player player = new Player();

        System.out.println("_________________________________________");

        System.out.println("\nNew game started! Shuffling cards...");
        gameDeck.shuffle();

        // System.out.println("\nPlease type one of the following commands");
        // System.out.println("- h (hit)");
        try{
            while(!quit) {
                System.out.println("\nBet ammount: ");
                String input = reader.readLine();
                if(input == "q") { // make sure the user can quit whenever they want
                    quit = true;
                    continue;
                }
                int ammount = Integer.parseInt(input); // add try catch block later
                player.bet(ammount);

                player.hit(gameDeck.draw());
                dealer.hit(gameDeck.draw());
                player.hit(gameDeck.draw());
                dealer.hit(gameDeck.draw());

                showState(player, dealer);

                boolean round = true;
                while(round) {
                    System.out.print("\nCommand: ");
                    String command = reader.readLine();

                    switch(command) {
                        case "h":
                            Card drawn = gameDeck.draw();
                            String result = player.hit(drawn);
                            if(result == "bust!") {
                                round = false;
                                System.out.println(drawn);
                                System.out.println(result);
                            } else {
                                System.out.println(drawn);
                            }
                            break;
                        case "s":
                            while(dealer.handTotal < 17) {
                                // flip other dealer card
                                System.out.println(dealer.viewHand());
                                Card dealerDrawn = gameDeck.draw();
                                System.out.println(dealerDrawn);
                                String dResult = dealer.hit(dealerDrawn);
                                if(dResult == "bust!") {
                                    System.out.println("Dealer busted, you win $" + ammount);
                                } else  if(player.handTotal > dealer.handTotal) {
                                    System.out.println("You beat the dealer!");
                                } else {
                                    System.out.println("Dealer beat you!");
                                }
                            }
                            break;
                        case "q":
                            System.out.println("Quitting game...\n");
                            round = false;
                            quit = true;
                            break;
                    }
                }
                
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void playGame(BufferedReader reader) {
        // set up the game deck, the player and the dealer
        boolean quit = false;
        Deck gameDeck = new Deck();
        Player player = new Player();
        player.funds = 50; // just for testing
        Player dealer = new Player();

        System.out.println("_________________________________________________");
        System.out.println("\nShuffling cards...");
        
        // shuffle the cards
        gameDeck.shuffle();

        // the overall loop indicating each hand of blackjack
        while(!quit) {
            // user first bets an ammount of money
            try {
                System.out.print("\nBet ammount: ");
                int amount = Integer.parseInt(reader.readLine());
                player.bet(amount);
                System.out.println("Betting $" + amount + "...");
            
                // deal two cards to the player and two to the dealer
                System.out.println("\nDealing cards...\n");
                player.hit(gameDeck.draw());
                dealer.hit(gameDeck.draw());
                player.hit(gameDeck.draw());
                dealer.hit(gameDeck.draw());

                // show the player thier two cards and the dealers top card
                System.out.println("Your hand:");
                System.out.println(player.viewHand());
                System.out.println("");
                System.out.println("Dealer top card:");
                System.out.println(dealer.dealerShowing());

                // inner loop for if the player wants to hit or stand while(...) {}
                boolean busted = false;
                boolean controlVar = true;
                while(controlVar) {
                    System.out.print("\nCommand: ");
                    String command = reader.readLine();
                    switch(command) {
                        case "h":
                            Card c = gameDeck.draw();
                            player.hit(c);
                            System.out.println(player.viewHand());
                            if(player.handTotal > 21) {
                                busted = true;
                                controlVar = false;
                                break;
                            }
                            break;
                        case "s":
                        controlVar = false;
                            break;
                    }
                }

                // if player busts then the player loses their money and the dealer only reveals the other hand in the deck
                if(busted) {
                    System.out.println("");
                    System.out.println("You busted! Dealer wins.");
                    System.out.println("Dealers hand: " + dealer.viewHand());
                    System.out.println("Remaining funds: " + player.funds);
                    player.reset();
                    dealer.reset();
                    continue;
                }

                // if the player stands then the dealer reveals the other card in their hand and keeps drawing cards until they hit a hand value of 17
                boolean dealerBust = false;
                boolean dealerStop = false;
                System.out.println("\nDealers hand: " + dealer.viewHand());
                if(dealer.handTotal < 17) {
                    while(!dealerStop) {
                        System.out.println("\nDealing: ");
                        dealer.hit(gameDeck.draw());
                        System.out.println(dealer.viewHand());
                        if(dealer.handTotal >= 17) {
                            dealerStop = true;
                            if(dealer.handTotal > 21) {
                                dealerBust = true;
                            }
                        }
                    }
                }
                

                // handle if dealer busted
                if(dealerBust) {
                    System.out.println("");
                    System.out.println("Dealer busted! You won $" + amount);
                    player.addWin(amount*2);
                    System.out.println("Total funds: $" + player.funds);
                }

                // if the dealer has a higher hand value then the player the dealer takes the players betted ammount
                else if(player.handTotal > dealer.handTotal) {
                    System.out.println("");
                    System.out.println("You beat the dealer! You won $" + amount);
                    player.addWin(amount*2);
                    System.out.println("Total funds: $" + player.funds);
                }

                // if the player beats the dealer the dealer matches the player bet
                else if(dealer.handTotal > player.handTotal) {
                    System.out.println("");
                    System.out.println("The dealer beat you! you lost $" + amount);
                    System.out.println("Total funds: $" + player.funds);
                }

                else {
                    System.out.println("");
                    System.out.println("Push");
                    player.addWin(amount);
                    System.out.println("Total funds: $" + player.funds);
                }

                player.reset();
                dealer.reset();

                // restart the loop
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage()); // catch any IOExceptions and print to the screen then repeate the loop
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for bet amount"); // catch if the user doesn't enter a number for their bet
            }
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