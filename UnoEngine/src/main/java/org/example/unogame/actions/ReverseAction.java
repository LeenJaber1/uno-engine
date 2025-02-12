package org.example.unogame.actions;

import org.example.Game;
import org.example.actions.ActionWithNoDecision;
import org.example.players.Player;

import java.util.List;

public class ReverseAction implements ActionWithNoDecision {
    @Override
    public void doAction(Game game) {
        List<Player> players = game.getPlayers();
        game.setClockWiseTurns(!game.isClockWiseTurns());
        int index = 0;
        for(int i = 0 ; i < players.size() ; i++){
            if(players.get(i).equals(game.getCurrentTurn())){
                index = i;
                break;
            }
        }
        Player nextPlayer = null;
        if(index == 0){
            nextPlayer = players.get(players.size() - 1);
        }
        else{
            nextPlayer = players.get(index - 1);
        }
        game.setCurrentTurn(nextPlayer);
    }
}
