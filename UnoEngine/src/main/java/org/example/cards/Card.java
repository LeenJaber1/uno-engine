package org.example.cards;

import org.example.enums.CardType;

public abstract class Card {
    private CardType cardType;

    public Card(CardType cardType) {
        this.cardType = cardType;
    }

    public Card() {
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
