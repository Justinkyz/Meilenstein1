package de.htw.webtech;

import java.util.Scanner;

public class Game {
    private GameService gameService;
    private InputHandler inputHandler;

    public Game() {
        gameService = new GameService();
        inputHandler = new InputHandler();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Blackjack!");

        while (gameService.getPlayer().getBalance() > 0) {
            gameService.startGame();

            // Player's turn
            System.out.println("Your hand: " + gameService.getPlayer().getHand() + " (" + gameService.getPlayer().getHand().getValue() + ")");
            while (true) {
                String action = inputHandler.getPlayerAction(scanner);
                if (action.equals("h")) {
                    gameService.playerHit();
                    System.out.println("Your hand: " + gameService.getPlayer().getHand() + " (" + gameService.getPlayer().getHand().getValue() + ")");
                    if (gameService.getPlayer().getHand().getValue() > 21) {
                        System.out.println("You bust! Dealer wins.");
                        gameService.playerLoses();
                        break;
                    }
                } else if (action.equals("s")) {
                    break;
                }
            }

            // Dealer's turn
            if (gameService.getPlayer().getHand().getValue() <= 21) {
                gameService.stand();  // this will call dealerTurn() inside it
                System.out.println("Dealer's hand: " + gameService.getDealer().getHand() + " (" + gameService.getDealer().getHand().getValue() + ")");
                System.out.println(gameService.getResult());
            }

            System.out.println("Your balance: " + gameService.getPlayer().getBalance());
            if (!inputHandler.playAgain(scanner)) {
                break;
            }
        }

        System.out.println("Game over! Your final balance: " + gameService.getPlayer().getBalance());
        scanner.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
