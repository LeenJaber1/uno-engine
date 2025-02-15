package org.example.cards;

import org.example.actions.Action;
import org.example.enums.CardType;
import org.example.enums.ColorSuit;
import org.example.enums.Number;

import java.util.List;

public interface CardFactory {
    Card createCardWithNoAction(CardType cardType, String label, Number number, ColorSuit colorSuit);

    Card createCardWithAction(CardType cardType, String label, List<Action> actions);

    Card createCardWithAction(CardType cardType, String label, List<Action> actions, ColorSuit colorSuit);
}
