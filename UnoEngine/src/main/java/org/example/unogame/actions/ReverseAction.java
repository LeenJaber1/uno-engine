package org.example.unogame.actions;

import org.example.Game;
import org.example.actions.ActionWithNoDecision;
import org.example.players.Player;

public class ReverseAction implements ActionWithNoDecision {
    @Override
    public void doAction(Game game) {
        game.setGameFlow(-1 * game.getGameFlow());
        Player nextPlayer = game.getNextPlayer();
        game.setCurrentTurn(nextPlayer);
    }
}
