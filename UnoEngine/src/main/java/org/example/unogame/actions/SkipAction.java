package org.example.unogame.actions;

import org.example.Game;
import org.example.actions.ActionWithNoDecision;
import org.example.players.Player;

import java.util.List;

public class SkipAction implements ActionWithNoDecision {
    @Override
    public void doAction(Game game) {
        List<Player> players = game.getPlayers();
        int index = 0;
        for(int i = 0 ; i < players.size() ; i++){
            if(players.get(i).equals(game.getCurrentTurn())){
                index = i;
                break;
            }
        }
        Player nextPlayer = players.get((index + 2)%players.size());
        game.setCurrentTurn(nextPlayer);
    }
}
