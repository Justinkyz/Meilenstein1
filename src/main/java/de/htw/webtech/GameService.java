package de.htw.webtech;

import org.springframework.stereotype.Service;

@Service
public class GameService {
    private Deck deck;
    private Player player;
    private Player dealer;

    public GameService() {
        deck = new Deck();
        player = new Player("Player", 1000);
        dealer = new Player("Dealer", Integer.MAX_VALUE);
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

        return getGameState();
    }

    public GameState hit() {
        player.getHand().addCard(deck.drawCard());
        return getGameState();
    }

    public GameState stand() {
        while (dealer.getHand().getValue() < 17) {
            dealer.getHand().addCard(deck.drawCard());
        }
        return getGameState();
    }

    public GameState getStatus() {
        return getGameState();
    }

    public GameState getGameState() {
        GameState gameState = new GameState();
        gameState.setPlayerHand(player.getHand().getCards());
        gameState.setDealerHand(dealer.getHand().getCards());
        gameState.setPlayerBalance(player.getBalance());
        gameState.setDealerBalance(dealer.getBalance());
        gameState.setResult(getResult());
        return gameState;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getDealer() {
        return dealer;
    }

    public void playerHit() {
        player.getHand().addCard(deck.drawCard());
    }

    public void playerLoses() {
        player.loseBet(10);
    }

    public void dealerTurn() {
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
}
