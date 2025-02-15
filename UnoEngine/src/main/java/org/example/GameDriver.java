package org.example;

import org.example.cards.CardFactory;
import org.example.unogame.UnoCardFactory;
import org.example.unogame.UnoGame;
import org.example.unogame.actions.ActionFactory;
import org.example.unogame.actions.UnoActionFactory;

import java.io.IOException;

public class GameDriver {
    public static void main(String[] args) throws IOException {
        CardFactory cardFactory = new UnoCardFactory();
        ActionFactory actionFactory = new UnoActionFactory();
        Game game = new UnoGame(1, cardFactory, actionFactory);
        game.play();
    }
}