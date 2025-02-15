package org.example.unogame;

import org.example.developerpackage.Game;
import org.example.developerpackage.actions.Action;
import org.example.developerpackage.cards.*;
import org.example.developerpackage.enums.CardType;
import org.example.developerpackage.enums.ColorSuit;
import org.example.developerpackage.enums.Number;
import org.example.developerpackage.players.Player;
import org.example.unogame.actions.ActionFactory;
import org.example.unogame.enums.ActionsWithDecisionEnum;
import org.example.unogame.enums.ActionsWithNoDecisionEnum;
import org.example.unogame.util.IOManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnoGame extends Game {
    private CardFactory cardFactory;
    private ActionFactory actionFactory;
    private IOManager ioManager = IOManager.getInstance();
    private BufferedWriter bufferedWriter = ioManager.getWriter();
    private BufferedReader bufferedReader = ioManager.getReader();

    public UnoGame(int gameFlow, CardFactory cardFactory, ActionFactory actionFactory) {
        super(gameFlow);
        this.cardFactory = cardFactory;
        this.actionFactory = actionFactory;
    }

    @Override
    public void createDeckOfCards() {
        List<Card> cards = new ArrayList<>();
        for (CardType cardtype : CardType.values()) {
            if (cardtype == CardType.COLORABLE_CARD) {
                createColoredCards(cards);
            } else if (cardtype == CardType.DECISION_CARD) {
                createDecisionCards(cards);
            }
        }
        this.setCards(cards);
    }

    private void createColoredCards(List<Card> cards) {
        for (ColorSuit colorSuit : ColorSuit.values()) {
            for (Number number : Number.values()) {
                Card card = cardFactory.createCardWithNoAction(CardType.COLORABLE_CARD, colorSuit.name() + " " + number.name(), number, colorSuit);
                //two cards from each color
                cards.add(card);
                cards.add(card);
            }
            for (ActionsWithNoDecisionEnum action : ActionsWithNoDecisionEnum.values()) {
                Action action1 = actionFactory.createActionWithNoDecision(action);
                Card card = cardFactory.createCardWithAction(CardType.COLORABLE_CARD, colorSuit + " " + action.name(), List.of(action1), colorSuit);
                //two cards from each color
                cards.add(card);
                cards.add(card);
            }
        }
    }

    private void createDecisionCards(List<Card> cards) {
        for (ActionsWithDecisionEnum decisionEnum : ActionsWithDecisionEnum.values()) {
            List<Action> actions = new ArrayList<>();
            Action action1 = actionFactory.createActionWithDecision(decisionEnum);
            actions.add(action1);
            Card card = cardFactory.createCardWithAction(CardType.DECISION_CARD, decisionEnum.name(), actions);
            for (int i = 0; i < 4; i++) {
                cards.add(card);
            }
        }
    }

    @Override
    public boolean isWinner(Player player) {
        return player.getCurrentCards().size() == 0;
    }

    @Override
    public void distributeCards() {
        List<Card> cards = this.getCards();
        Iterator<Card> iterator = cards.iterator();
        for (Player player : this.getPlayers()) {
            for (int j = 0; j < this.getInitialNumberOfCards() && iterator.hasNext(); j++) {
                player.getCurrentCards().add(iterator.next());
                iterator.remove();
            }
        }
    }

    @Override
    public boolean isValidCardToPlace(Card card) {
        if (card instanceof DecisionCard) {
            return true;
        }
        if (card instanceof ColorableCard && this.getColorOfTopCard() == ((ColorableCard) card).getColor()) {
            return true;
        }
        if (card instanceof NumberedCard && this.getTopCard() instanceof NumberedCard) {
            if (((NumberedCard) card).getNumber() == ((NumberedCard) this.getTopCard()).getNumber()) {
                return true;
            }
        }
        String firstWord1 = card.getCardLabel().split(" ")[1];
        String firstWord2 = this.getTopCard().getCardLabel().split(" ")[1];
        if (firstWord1.equals(firstWord2)) {
            return true;
        }

        return false;
    }

    @Override
    public void showPlayerCards(Player player) throws IOException {
        bufferedWriter.write("Cards : ");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        int cardNumber = 1;
        for (Card card : player.getCurrentCards()) {
            bufferedWriter.write(cardNumber + " " + card.getCardLabel());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            cardNumber++;
        }
        System.out.println();
    }

    @Override
    public void showTopCard(Card card) throws IOException {
        bufferedWriter.write("Top card : " + card.getCardLabel());
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    @Override
    public Card getChosenCard(Player player) throws IOException {
        bufferedWriter.write("Choose the card number to place : ");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        int cardNumber = Integer.parseInt(bufferedReader.readLine().trim());
        return player.getCurrentCards().get(cardNumber - 1);
    }

    @Override
    public Player getNextPlayer() {
        List<Player> players = this.getPlayers();
        int index = -1;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).equals(this.getCurrentTurn())) {
                index = i;
                break;
            }
        }

        return players.get((index + this.getGameFlow() + players.size()) % players.size());
    }

    @Override
    public void doActions(Card card) throws IOException {
        if (card instanceof ActionCard) {
            List<Action> actions = ((ActionCard) card).getActions();
            for (Action action : actions) {
                action.doAction(this);
            }
        }
        if (card instanceof DecisionCard) {
            List<Action> actions = ((DecisionCard) card).getActions();
            for (Action action : actions) {
                action.doAction(this);
            }
        }

    }


    @Override
    public Card getTopCard() {
        Card card = null;
        for (Card cards : this.getCards()) {
            if (cards instanceof NumberedCard) {
                card = cards;
                break;
            }
        }
        return card;
    }
}
