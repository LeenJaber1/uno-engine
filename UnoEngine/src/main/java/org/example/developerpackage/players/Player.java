package org.example.developerpackage.players;

import org.example.developerpackage.cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private String name;
    private int numberOfCards;
    private List<Card> currentCards = new ArrayList<>();

    public Player(String name, int numberOfCards) {
        this.name = name;
        this.numberOfCards = numberOfCards;
    }

    public void removeCard(Card card) {
        for (int i = 0; i < this.currentCards.size(); i++) {
            if (this.currentCards.get(i).equals(card)) {
                this.currentCards.remove(i);
                return;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfcards() {
        return numberOfCards;
    }

    public void setNumberOfcards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public List<Card> getCurrentCards() {
        return currentCards;
    }

    public void setCurrentCards(List<Card> currentCards) {
        this.currentCards = currentCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return numberOfCards == player.numberOfCards && Objects.equals(name, player.name) && Objects.equals(currentCards, player.currentCards);
    }
}
