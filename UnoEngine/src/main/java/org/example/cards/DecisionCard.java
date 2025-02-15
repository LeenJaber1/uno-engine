package org.example.cards;

import org.example.actions.Action;
import org.example.enums.CardType;

import java.util.ArrayList;
import java.util.List;

public class DecisionCard extends Card {
    List<Action> actions;

    public DecisionCard(CardType cardType, String cardLabel, List<Action> actions) {
        super(cardType, cardLabel);
        this.actions = actions;
    }

    public DecisionCard() {
        actions = new ArrayList<>();
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
