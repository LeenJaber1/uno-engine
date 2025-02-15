package org.example.unogame.actions;

import org.example.developerpackage.Game;
import org.example.developerpackage.actions.ActionWithNoDecision;
import org.example.developerpackage.players.Player;

public class DrawTwoAction implements ActionWithNoDecision {
    @Override
    public void doAction(Game game) {
        Player nextPlayer = game.getNextPlayer();
        for (int i = 0; i < 2; i++) {
            game.draw(nextPlayer);

        }
    }
}
