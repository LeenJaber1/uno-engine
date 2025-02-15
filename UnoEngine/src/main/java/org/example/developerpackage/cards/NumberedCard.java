package org.example.developerpackage.cards;

import org.example.developerpackage.enums.CardType;
import org.example.developerpackage.enums.ColorSuit;
import org.example.developerpackage.enums.Number;

public class NumberedCard extends ColorableCard {
    private Number number;

    public NumberedCard(CardType cardType, String cardLabel, ColorSuit color, Number number) {
        super(cardType, cardLabel, color);
        this.number = number;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }
}
