package de.htw.webtech;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            value += card.getRank().getValue();
            if (card.getRank() == Card.Rank.ACE) {
                aceCount++;
            }
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void clear() {
        cards.clear();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
