package org.example.cards;

import org.example.actions.Action;
import org.example.enums.CardType;
import org.example.enums.ColorSuit;

import java.util.ArrayList;
import java.util.List;

public class ActionCard extends ColorableCard {
    private List<Action> actions;

    public ActionCard(CardType cardType, ColorSuit color, List<Action> actions) {
        super(cardType, color);
        this.actions = actions;
    }

    public ActionCard() {
        this.actions = new ArrayList<>();
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
