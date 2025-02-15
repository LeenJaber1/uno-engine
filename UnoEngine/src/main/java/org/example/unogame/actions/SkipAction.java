package org.example.unogame.actions;

import org.example.Game;
import org.example.actions.ActionWithNoDecision;
import org.example.players.Player;

import java.util.List;

public class SkipAction implements ActionWithNoDecision {
    @Override
    public void doAction(Game game) {
        List<Player> players = game.getPlayers();
        Player skippedPlayer = game.getNextPlayer();
        int index = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).equals(skippedPlayer)) {
                index = i;
                break;
            }
        }
        Player nextPlayer = players.get((index + 2 * game.getGameFlow()) % players.size());
        game.setCurrentTurn(nextPlayer);
    }
}
