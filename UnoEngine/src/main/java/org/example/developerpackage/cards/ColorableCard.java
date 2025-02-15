package org.example.developerpackage.cards;

import org.example.developerpackage.enums.CardType;
import org.example.developerpackage.enums.ColorSuit;

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
