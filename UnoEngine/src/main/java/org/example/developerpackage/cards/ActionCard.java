package org.example.developerpackage.cards;

import org.example.developerpackage.actions.Action;
import org.example.developerpackage.enums.CardType;
import org.example.developerpackage.enums.ColorSuit;

import java.util.ArrayList;
import java.util.List;

public class ActionCard extends ColorableCard {
    private List<Action> actions;

    public ActionCard(CardType cardType, ColorSuit color, String cardLabel, List<Action> actions) {
        super(cardType, cardLabel, color);
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
