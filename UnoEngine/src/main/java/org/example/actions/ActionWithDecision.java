package org.example.actions;

import org.example.Game;

public interface ActionWithDecision extends Action{
    void doDecision(Game game);
}
