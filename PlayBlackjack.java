public class PlayBlackjack {
    public static void main(String[] args) {
        Deck deck = new Deck();

        System.out.println(deck.draw());
        deck.shuffle();
        System.out.println(deck.draw());
        System.out.println(deck.draw());
        System.out.println(deck.draw());
        System.out.println(deck.draw());
    }
}