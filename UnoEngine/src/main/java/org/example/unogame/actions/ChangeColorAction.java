package org.example.unogame.actions;

import org.example.developerpackage.Game;
import org.example.developerpackage.actions.ActionWithDecision;
import org.example.developerpackage.enums.ColorSuit;
import org.example.unogame.util.IOManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ChangeColorAction implements ActionWithDecision {
    private IOManager ioManager = IOManager.getInstance();
    private BufferedWriter bufferedWriter = ioManager.getWriter();
    private BufferedReader bufferedReader = ioManager.getReader();

    @Override
    public void doAction(Game game) throws IOException {
        String choosenColor = doDecision(game);
        for (ColorSuit color : ColorSuit.values()) {
            if (choosenColor.toUpperCase().equals(color.name())) {
                game.setColorOfTopCard(color);
                return;
            }
        }
    }

    @Override
    public String doDecision(Game game) throws IOException {
        bufferedWriter.write("Choose the color you want :");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        int i = 1;
        for (ColorSuit color : ColorSuit.values()) {
            bufferedWriter.write(i + ". " + color.name());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            i++;
        }
        String choosenColor = bufferedReader.readLine();
        return choosenColor;
    }
}
