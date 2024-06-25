package de.htw.webtech;

import java.util.Scanner;

public class Game {
    private Deck deck;
    private Player player;
    private Player dealer;

    public Game() {
        deck = new Deck();
        player = new Player("Player", 1000);
        dealer = new Player("Dealer", Integer.MAX_VALUE);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Blackjack!");

        while (player.getBalance() > 0) {
            player.getHand().clear();
            dealer.getHand().clear();
            deck = new Deck(); // Reset the deck

            // Deal initial cards
            player.getHand().addCard(deck.drawCard());
            player.getHand().addCard(deck.drawCard());
            dealer.getHand().addCard(deck.drawCard());
            dealer.getHand().addCard(deck.drawCard());

            // Player's turn
            System.out.println("Your hand: " + player.getHand() + " (" + player.getHand().getValue() + ")");
            while (true) {
                System.out.print("Hit or stand? (h/s): ");
                String action = scanner.nextLine();
                if (action.equals("h")) {
                    player.getHand().addCard(deck.drawCard());
                    System.out.println("Your hand: " + player.getHand() + " (" + player.getHand().getValue() + ")");
                    if (player.getHand().getValue() > 21) {
                        System.out.println("You bust! Dealer wins.");
                        player.loseBet(10);
                        break;
                    }
                } else if (action.equals("s")) {
                    break;
                } else {
                    System.out.println("Invalid action. Please enter 'h' or 's'.");
                }
            }

            // Dealer's turn
            if (player.getHand().getValue() <= 21) {
                System.out.println("Dealer's hand: " + dealer.getHand() + " (" + dealer.getHand().getValue() + ")");
                while (dealer.getHand().getValue() < 17) {
                    dealer.getHand().addCard(deck.drawCard());
                    System.out.println("Dealer's hand: " + dealer.getHand() + " (" + dealer.getHand().getValue() + ")");
                }
                if (dealer.getHand().getValue() > 21) {
                    System.out.println("Dealer busts! You win.");
                    player.winBet(10);
                } else if (dealer.getHand().getValue() > player.getHand().getValue()) {
                    System.out.println("Dealer wins.");
                    player.loseBet(10);
                } else if (dealer.getHand().getValue() < player.getHand().getValue()) {
                    System.out.println("You win.");
                    player.winBet(10);
                } else {
                    System.out.println("It's a tie.");
                }
            }

            System.out.println("Your balance: " + player.getBalance());
            System.out.print("Play again? (y/n): ");
            String playAgain = scanner.nextLine();
            if (!playAgain.equals("y")) {
                break;
            }
        }

        System.out.println("Game over! Your final balance: " + player.getBalance());
        scanner.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
