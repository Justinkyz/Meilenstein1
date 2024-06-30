package de.htw.webtech;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private Deck deck;
    private Player player;
    private Player dealer;
    private String status;

    public GameService() {
        deck = new Deck();
        player = new Player("Player", 1000);
        dealer = new Player("Dealer", Integer.MAX_VALUE);
        status = "NEW";
    }

    public GameState startGame() {
        player.getHand().clear();
        dealer.getHand().clear();
        deck = new Deck(); // Reset the deck

        // Deal initial cards
        player.getHand().addCard(deck.drawCard());
        player.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());

        status = "IN_PROGRESS";

        return getGameState();
    }

    public GameState hit() {
        player.getHand().addCard(deck.drawCard());
        if (player.getHand().getValue() > 21) {
            status = "PLAYER_BUST";
        }
        return getGameState();
    }

    public GameState stand() {
        dealerTurn();
        status = getResult();
        return getGameState();
    }

    private void dealerTurn() {
        while (dealer.getHand().getValue() < 17) {
            dealer.getHand().addCard(deck.drawCard());
        }
    }

    public String getResult() {
        if (player.getHand().getValue() > 21) {
            return "Player busts! Dealer wins.";
        } else if (dealer.getHand().getValue() > 21) {
            return "Dealer busts! Player wins.";
        } else if (dealer.getHand().getValue() > player.getHand().getValue()) {
            return "Dealer wins.";
        } else if (dealer.getHand().getValue() < player.getHand().getValue()) {
            return "Player wins.";
        } else {
            return "It's a tie.";
        }
    }

    public GameState getGameState() {
        GameState gameState = new GameState();
        gameState.setPlayerHand(player.getHand().getCards());
        gameState.setDealerHand(dealer.getHand().getCards());
        gameState.setPlayerBalance(player.getBalance());
        gameState.setDealerBalance(dealer.getBalance());
        gameState.setStatus(status);
        gameState.setResult(getResult());
        return gameState;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getDealer() {
        return dealer;
    }

    // Methods that are used in Game.java
    public void playerHit() {
        player.getHand().addCard(deck.drawCard());
    }

    public void playerLoses() {
        player.loseBet(10);
    }
}
