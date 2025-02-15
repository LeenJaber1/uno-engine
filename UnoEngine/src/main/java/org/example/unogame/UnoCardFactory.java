package org.example.unogame;

import org.example.actions.Action;
import org.example.cards.*;
import org.example.enums.CardType;
import org.example.enums.ColorSuit;
import org.example.enums.Number;

import java.util.List;

public class UnoCardFactory implements CardFactory {
    @Override
    public Card createCardWithNoAction(CardType cardType, String label, Number number, ColorSuit colorSuit) {
        Card card = new NumberedCard(cardType, label, colorSuit, number);
        return card;
    }

    @Override
    public Card createCardWithAction(CardType cardType, String label, List<Action> actions) {
        Card card = new DecisionCard(cardType, label, actions);
        return card;
    }

    @Override
    public Card createCardWithAction(CardType cardType, String label, List<Action> actions, ColorSuit colorSuit) {
        Card card = new ActionCard(cardType, colorSuit, label, actions);
        return card;
    }


}
