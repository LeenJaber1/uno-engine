package org.example.unogame.actions;

import org.example.developerpackage.actions.Action;
import org.example.developerpackage.actions.ActionWithDecision;
import org.example.developerpackage.actions.ActionWithNoDecision;
import org.example.unogame.enums.ActionsWithDecisionEnum;
import org.example.unogame.enums.ActionsWithNoDecisionEnum;

public class UnoActionFactory implements ActionFactory {

    @Override
    public ActionWithNoDecision createActionWithNoDecision(ActionsWithNoDecisionEnum noDecisionEnum) {
        Action action = null;
        if (noDecisionEnum == ActionsWithNoDecisionEnum.REVERSE) {
            action = new ReverseAction();
        } else if (noDecisionEnum == ActionsWithNoDecisionEnum.SKIP) {
            action = new SkipAction();
        } else if (noDecisionEnum == ActionsWithNoDecisionEnum.DRAW_TWO) {
            action = new DrawTwoAction();
        }
        return (ActionWithNoDecision) action;
    }

    @Override
    public ActionWithDecision createActionWithDecision(ActionsWithDecisionEnum decisionEnum) {
        Action action = null;
        if (decisionEnum == ActionsWithDecisionEnum.CHANGE_COLOR) {
            action = new ChangeColorAction();
        } else if (decisionEnum == ActionsWithDecisionEnum.DRAW_FOUR) {
            action = new DrawFourAction();
        }
        return (ActionWithDecision) action;
    }
}
