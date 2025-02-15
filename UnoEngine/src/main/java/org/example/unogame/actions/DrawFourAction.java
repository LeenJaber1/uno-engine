package org.example.unogame.actions;

import org.example.Game;
import org.example.actions.ActionWithDecision;
import org.example.enums.ColorSuit;
import org.example.players.Player;

import java.io.IOException;

public class DrawFourAction implements ActionWithDecision {
    @Override
    public void doAction(Game game) throws IOException {
        String color1 = doDecision(game);
        for (ColorSuit color : ColorSuit.values()) {
            if (color1.toUpperCase().equals(color.name())) {
                game.setColorOfTopCard(color);
                break;
            }
        }
        Player nextPlayer = game.getNextPlayer();
        for (int i = 0; i < 4; i++) {
            game.draw(nextPlayer);
        }
    }

    @Override
    public String doDecision(Game game) throws IOException {
        ChangeColorAction changeColorAction = new ChangeColorAction();
        return changeColorAction.doDecision(game);
    }
}
