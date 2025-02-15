package org.example.developerpackage;


import org.example.developerpackage.cards.Card;
import org.example.developerpackage.cards.ColorableCard;
import org.example.developerpackage.enums.ColorSuit;
import org.example.developerpackage.players.Player;
import org.example.unogame.util.IOManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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
    private int gameFlow;
    private ColorSuit colorOfTopCard;

    private IOManager ioManager = IOManager.getInstance();
    private BufferedWriter bufferedWriter = ioManager.getWriter();
    private BufferedReader bufferedReader = ioManager.getReader();

    public Game(int gameFlow) {
        this.gameFlow = gameFlow;
    }

    //how the developer wants to create the cards
    public abstract void createDeckOfCards();

    // the criteria of winning based on the developer
    public abstract boolean isWinner(Player player);

    // distribute cards for the players based on what criteria
    public abstract void distributeCards();

    public abstract boolean isValidCardToPlace(Card card);

    public abstract void showPlayerCards(Player player) throws IOException;

    public abstract void showTopCard(Card card) throws IOException;

    //take input for which card to place
    public abstract Card getChosenCard(Player player) throws IOException;

    public abstract Player getNextPlayer();

    public abstract void doActions(Card card) throws IOException;

    public abstract Card getTopCard();

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }

    public void play() throws IOException {
        createDeckOfCards();
        registerPlayers();
        shuffle(this.cards);
        distributeCards();
        this.topCard = getTopCard();
        this.colorOfTopCard = ((ColorableCard) this.topCard).getColor();
        while (!isWinner(this.currentTurn)) {
            bufferedWriter.write(this.currentTurn.getName() + "'s" + " turn");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            showTopCard(this.topCard);
            showPlayerCards(this.currentTurn);

            boolean decisionToDraw = getDecisionToDraw();
            if (decisionToDraw) {
                draw(this.currentTurn);
                continue;
            }
            Card card = getChosenCard(this.currentTurn);
            if (isValidCardToPlace(card)) {
                this.topCard = card;
                if (card instanceof ColorableCard) {
                    this.colorOfTopCard = ((ColorableCard) card).getColor();
                }
                this.currentTurn.removeCard(card);
                this.currentTurn.setNumberOfcards(this.currentTurn.getNumberOfcards() - 1);
                doActions(card);
            } else {
                System.out.println("Choose another card !");
                continue;
            }
            if(isWinner(this.currentTurn)){
                bufferedWriter.write(this.currentTurn.getName() + " is the winner !!!");
                bufferedWriter.newLine();
                bufferedWriter.flush();
                break;
            }
            this.currentTurn = getNextPlayer();
        }
        this.ioManager.close();
    }

    private void registerPlayers() throws IOException {
        bufferedWriter.write("Maximum number of players is :" + this.getMaxPlayers());
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.write("Enter how many players playing : ");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        int num = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i < num; i++) {
            bufferedWriter.write("Enter player name : ");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            String name = bufferedReader.readLine();
            Player player = new Player(name, this.initialNumberOfCards);
            this.players.add(player);
        }
        this.currentTurn = this.players.get(0);
    }

    public void draw(Player player) {
        Card drawnCard = this.cards.get(this.cards.size() - 1);
        player.getCurrentCards().add(drawnCard);
        this.cards.remove(this.cards.size() - 1);
        player.setNumberOfcards(player.getNumberOfcards() + 1);
    }

    private boolean getDecisionToDraw() throws IOException {
        bufferedWriter.write("Would you like to draw ? yes ? no");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        String ans = bufferedReader.readLine();
        if (ans.toLowerCase().equals("yes")) {
            return true;
        }
        return false;
    }

    public void shuffle(List<Card> cards) {
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

    public int getInitialNumberOfCards() {
        return initialNumberOfCards;
    }

    public void setInitialNumberOfCards(int initialNumberOfCards) {
        this.initialNumberOfCards = initialNumberOfCards;
    }

    public ColorSuit getColorOfTopCard() {
        return colorOfTopCard;
    }

    public void setColorOfTopCard(ColorSuit colorOfTopCard) {
        this.colorOfTopCard = colorOfTopCard;
    }

    public int getGameFlow() {
        return gameFlow;
    }

    public void setGameFlow(int gameFlow) {
        this.gameFlow = gameFlow;
    }
}
