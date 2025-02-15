package org.example.actions;

import org.example.Game;

import java.io.IOException;

public interface ActionWithDecision extends Action {
    String doDecision(Game game) throws IOException;
}
