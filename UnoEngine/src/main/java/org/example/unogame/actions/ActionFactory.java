package org.example.unogame.actions;

import org.example.developerpackage.actions.ActionWithDecision;
import org.example.developerpackage.actions.ActionWithNoDecision;
import org.example.unogame.enums.ActionsWithDecisionEnum;
import org.example.unogame.enums.ActionsWithNoDecisionEnum;

public interface ActionFactory {
    ActionWithNoDecision createActionWithNoDecision(ActionsWithNoDecisionEnum noDecisionEnum);

    ActionWithDecision createActionWithDecision(ActionsWithDecisionEnum decisionEnum);
}
