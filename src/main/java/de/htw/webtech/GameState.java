package de.htw.webtech;

import java.util.List;

public class GameState {
    private List<Card> playerHand;
    private List<Card> dealerHand;
    private int playerBalance;
    private int dealerBalance;
    private String result;

    // Getter und Setter
    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(List<Card> playerHand) {
        this.playerHand = playerHand;
    }

    public List<Card> getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(List<Card> dealerHand) {
        this.dealerHand = dealerHand;
    }

    public int getPlayerBalance() {
        return playerBalance;
    }

    public void setPlayerBalance(int playerBalance) {
        this.playerBalance = playerBalance;
    }

    public int getDealerBalance() {
        return dealerBalance;
    }

    public void setDealerBalance(int dealerBalance) {
        this.dealerBalance = dealerBalance;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
