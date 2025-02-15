package org.example.unogame.actions;

import org.example.developerpackage.Game;
import org.example.developerpackage.actions.ActionWithNoDecision;
import org.example.developerpackage.players.Player;

public class ReverseAction implements ActionWithNoDecision {
    @Override
    public void doAction(Game game) {
        game.setGameFlow(-1 * game.getGameFlow());
        Player nextPlayer = game.getNextPlayer();
        game.setCurrentTurn(nextPlayer);
    }
}
