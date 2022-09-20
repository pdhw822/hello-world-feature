package com.rundeck.feature.helloworld;

import com.rundeck.feature.api.event.ActionCompleteEvent;

public class FailureActionCompletion implements ActionCompleteEvent {
    private String actionId;
    private Long ts = System.nanoTime();

    public FailureActionCompletion(String actionId) {
        this.actionId = actionId;
    }

    @Override
    public CompletionStatus getStatus() {
        return CompletionStatus.ERROR;
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
