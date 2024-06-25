package de.htw.webtech;

public class Player {
    private String name;
    private Hand hand;
    private int balance;

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public int getBalance() {
        return balance;
    }

    public void winBet(int amount) {
        balance += amount;
    }

    public void loseBet(int amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return name + "'s hand: " + hand;
    }
}
