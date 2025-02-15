package org.example.cards;

import org.example.enums.CardType;

public abstract class Card {
    private CardType cardType;
    private String cardLabel;

    public Card(CardType cardType, String cardLabel) {
        this.cardType = cardType;
        this.cardLabel = cardLabel;
    }

    public Card() {
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCardLabel() {
        return cardLabel;
    }

    public void setCardLabel(String cardLabel) {
        this.cardLabel = cardLabel;
    }
}
