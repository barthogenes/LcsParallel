package com.hva.lcs.model.tablelog;

import java.util.List;

public class ActionReplayer {

    private List<TableOperation> actionLog;

    private int timeLinePosition;

    public ActionReplayer(List<TableOperation> actionLog) {
        this.actionLog = actionLog;
        this.timeLinePosition = 0;
    }

    public int getActionNumber() { return timeLinePosition; }

    public int getActionsTotal() {
        return actionLog.size();
    }

    public TableOperation getNextAction() {
        TableOperation action;
        if (timeLinePosition < actionLog.size()) {
            action = actionLog.get(timeLinePosition++);
            return action;
        } else {
            return null;
        }
    }

    public TableOperation getPreviousAction() {
        TableOperation action;
        if (timeLinePosition > 0) {
            action = actionLog.get(timeLinePosition--);
            return action;
        } else {
            return null;
        }
    }

}
