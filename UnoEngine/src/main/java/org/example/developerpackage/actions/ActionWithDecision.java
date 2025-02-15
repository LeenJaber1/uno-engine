package org.example.developerpackage.actions;

import org.example.developerpackage.Game;

import java.io.IOException;

public interface ActionWithDecision extends Action {
    String doDecision(Game game) throws IOException;
}
