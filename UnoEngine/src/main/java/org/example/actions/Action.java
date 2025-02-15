package org.example.actions;

import org.example.Game;

import java.io.IOException;

public interface Action {
    void doAction(Game game) throws IOException;
}
