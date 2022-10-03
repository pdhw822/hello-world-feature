package com.rundeck.feature.helloworld.actions;

import com.rundeck.feature.api.action.FeatureAction;
import com.rundeck.feature.api.context.ContextKeys;
import com.rundeck.feature.api.context.FeatureActionContext;
import com.rundeck.feature.api.model.CompletionStatus;
import com.rundeck.feature.helloworld.DefaultActionOutputEvent;


public class EchoFeatureAction implements FeatureAction<EchoFeatureActionData> {
    public static final String ACTION = "echo";
    public static final String DESC = "Echo the provided echo string";
    @Override
    public String getName() {
        return ACTION;
    }

    @Override
    public String getDescription() {
        return DESC;
    }

    @Override
    public CompletionStatus execute(FeatureActionContext featureActionContext) {
        EchoFeatureActionData data = featureActionContext.get(ContextKeys.ACTION_DATA, EchoFeatureActionData.class);
        featureActionContext.getEventPublisher().publishOutput(new DefaultActionOutputEvent(featureActionContext.getActionId(), data.getEcho(), featureActionContext.getUser()));
        return CompletionStatus.SUCCESS;
    }

    @Override
    public Class<EchoFeatureActionData> getFeatureActionDataClass() {
        return EchoFeatureActionData.class;
    }

    @Override
    public EchoFeatureActionData getSampleActionData() {
        return new EchoFeatureActionData("Echo me");
    }
}
