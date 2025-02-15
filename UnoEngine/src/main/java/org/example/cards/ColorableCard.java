package org.example.cards;

import org.example.enums.CardType;
import org.example.enums.ColorSuit;

public class ColorableCard extends Card {
    private ColorSuit color;

    public ColorableCard(CardType cardType, String cardLabel, ColorSuit color) {
        super(cardType, cardLabel);
        this.color = color;
    }

    public ColorableCard() {
    }

    public ColorSuit getColor() {
        return color;
    }

    public void setColor(ColorSuit color) {
        this.color = color;
    }
}
