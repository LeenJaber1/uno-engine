package org.example.cards;

import org.example.enums.CardType;
import org.example.enums.ColorSuit;
import org.example.enums.Number;

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
