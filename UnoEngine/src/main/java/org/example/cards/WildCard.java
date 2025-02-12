package org.example.cards;

import org.example.actions.Action;
import org.example.enums.CardType;

import java.util.ArrayList;
import java.util.List;

public class WildCard extends Card {
    List<Action> actions;

    public WildCard(CardType cardType, List<Action> actions) {
        super(cardType);
        this.actions = actions;
    }

    public WildCard() {
        actions = new ArrayList<>();
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
