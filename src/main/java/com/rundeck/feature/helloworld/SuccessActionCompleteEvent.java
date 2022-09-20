package com.rundeck.feature.helloworld;

import com.rundeck.feature.api.event.ActionCompleteEvent;

public class SuccessActionCompleteEvent implements ActionCompleteEvent {

    String actionId;
    Long ts = System.nanoTime();

    public SuccessActionCompleteEvent(String actionId) {
        this.actionId = actionId;
    }

    @Override
    public CompletionStatus getStatus() {
        return CompletionStatus.SUCCESS;
    }

    @Override
    public String getActionId() {
        return actionId;
    }

    @Override
    public Long getTimestamp() {
        return ts;
    }
}
