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

    public void startGame() {
        player.getHand().clear();
        dealer.getHand().clear();
        deck = new Deck(); // Reset the deck

        // Deal initial cards
        player.getHand().addCard(deck.drawCard());
        player.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());
    }

    public void playerHit() {
        player.getHand().addCard(deck.drawCard());
    }

    public void dealerTurn() {
        while (dealer.getHand().getValue() < 17) {
            dealer.getHand().addCard(deck.drawCard());
        }
    }

    public void playerLoses() {
        player.loseBet(10);
    }

    public void playerWins() {
        player.winBet(10);
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

    public Player getPlayer() {
        return player;
    }

    public Player getDealer() {
        return dealer;
    }

    // Add the hit method
    public Card hit() {
        Card newCard = deck.drawCard();
        player.getHand().addCard(newCard);
        return newCard;
    }

    // Add the stand method
    public void stand() {
        dealerTurn();
    }
}
