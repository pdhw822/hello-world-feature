package com.rundeck.feature.helloworld;

import com.rundeck.feature.api.output.ActionOutputEvent;
import com.rundeck.feature.api.output.OutputLevel;

public class DefaultActionOutputEvent implements ActionOutputEvent {
    String actionId;
    OutputLevel level;
    String message;
    String user;
    Long timestamp;

    public DefaultActionOutputEvent() {
    }

    public DefaultActionOutputEvent(String actionId, String message, String user) {
        this(actionId, OutputLevel.NORMAL, message, user, System.nanoTime());
    }

    public DefaultActionOutputEvent(String actionId, OutputLevel level, String message, String user, Long timestamp) {
        this.actionId = actionId;
        this.level = level;
        this.message = message;
        this.timestamp = timestamp;
        this.user = user;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public OutputLevel getLevel() {
        return level;
    }

    public void setLevel(OutputLevel level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
