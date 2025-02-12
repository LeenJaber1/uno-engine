package org.example.cards;

import org.example.actions.Action;
import org.example.enums.CardType;

import java.util.ArrayList;
import java.util.List;

public class SpecialCard extends Card {
    List<Action> actions;
    public SpecialCard(CardType cardType, List<Action> actions) {
        super(cardType);
        this.actions = actions;
    }

    public SpecialCard() {
        actions = new ArrayList<>();
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
