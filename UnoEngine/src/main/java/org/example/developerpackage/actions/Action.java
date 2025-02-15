package org.example.developerpackage.actions;

import org.example.developerpackage.Game;

import java.io.IOException;

public interface Action {
    void doAction(Game game) throws IOException;
}
