package org.example.unogame.actions;

import org.example.actions.ActionWithDecision;
import org.example.actions.ActionWithNoDecision;
import org.example.unogame.enums.ActionsWithDecisionEnum;
import org.example.unogame.enums.ActionsWithNoDecisionEnum;

public interface ActionFactory {
    ActionWithNoDecision createActionWithNoDecision(ActionsWithNoDecisionEnum noDecisionEnum);

    ActionWithDecision createActionWithDecision(ActionsWithDecisionEnum decisionEnum);
}
