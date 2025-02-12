package org.example;

import org.example.cards.Card;
import org.example.players.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Game {
    private List<Card> cards = new ArrayList<>();
    private int totalNumberOfCards = 108;
    private int maxPlayers = 5;
    private List<Player> players = new ArrayList<>();
    private Player currentTurn;
    private Card topCard;
    private int initialNumberOfCards = 7;

    //how the developer wants to create the cards
    public abstract void createDeckOfCards();

    // the criteria of winning based on the developer
    public abstract boolean isWinner(Player player);

    // distribute cards for the players based on what criteria
    public abstract void distributeCards();

    public abstract boolean isValidCardToPlace(Card card);

    public abstract void showPlayerCards(Player player);

    public abstract void showTopCard(Card card);

    //take input for which card to place
    public abstract Card getChosenCard(Player player);

    public abstract Player getNextPlayer();

    public void play(){
        shuffle(this.cards);
        distributeCards();
        while(!isWinner(this.currentTurn)){
            showTopCard(this.topCard);
            showPlayerCards(this.currentTurn);
            Card card = getChosenCard(this.currentTurn);
            if(isValidCardToPlace(card)){
                this.topCard = card;
                this.currentTurn.removeCard(card);
            }
            this.currentTurn = getNextPlayer();
        }
    };

    public void shuffle(List<Card> cards){
        Collections.shuffle(this.cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getTotalNumberOfCards() {
        return totalNumberOfCards;
    }

    public void setTotalNumberOfCards(int totalNumberOfCards) {
        this.totalNumberOfCards = totalNumberOfCards;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Player currentTurn) {
        this.currentTurn = currentTurn;
    }

    public Card getTopCard() {
        return topCard;
    }

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }

    public int getInitialNumberOfCards() {
        return initialNumberOfCards;
    }

    public void setInitialNumberOfCards(int initialNumberOfCards) {
        this.initialNumberOfCards = initialNumberOfCards;
    }
}
