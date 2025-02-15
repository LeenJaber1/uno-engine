package org.example.developerpackage.cards;

import org.example.developerpackage.actions.Action;
import org.example.developerpackage.enums.CardType;
import org.example.developerpackage.enums.ColorSuit;
import org.example.developerpackage.enums.Number;

import java.util.List;

public interface CardFactory {
    Card createCardWithNoAction(CardType cardType, String label, Number number, ColorSuit colorSuit);

    Card createCardWithAction(CardType cardType, String label, List<Action> actions);

    Card createCardWithAction(CardType cardType, String label, List<Action> actions, ColorSuit colorSuit);
}
