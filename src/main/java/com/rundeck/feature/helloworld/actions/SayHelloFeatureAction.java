package com.rundeck.feature.helloworld.actions;

import com.rundeck.feature.api.action.FeatureAction;
import com.rundeck.feature.api.action.FeatureActionContext;
import com.rundeck.feature.api.output.OutputLevel;
import com.rundeck.feature.helloworld.DefaultActionOutputEvent;
import com.rundeck.feature.helloworld.FailureActionCompletion;
import com.rundeck.feature.helloworld.HelloWorldFeatureConfig;
import com.rundeck.feature.helloworld.SuccessActionCompleteEvent;

import java.util.Optional;

public class SayHelloFeatureAction implements FeatureAction<SayHelloFeatureActionData> {
    public static final String ACTION = "say-hello";
    public String getName() {
        return ACTION;
    }

    public void execute(final FeatureActionContext featureActionContext) {
        try {
            SayHelloFeatureActionData data = featureActionContext.get(FeatureActionContext.KEY_ACTION_DATA, SayHelloFeatureActionData.class);
            if(data == null) data = new SayHelloFeatureActionData();
            HelloWorldFeatureConfig featureConfig = featureActionContext.get(FeatureActionContext.KEY_FEATURE_CONFIG, HelloWorldFeatureConfig.class);
            if(featureConfig == null) featureConfig = new HelloWorldFeatureConfig();
            featureActionContext.getEventPublisher().publishOutput(new DefaultActionOutputEvent(featureActionContext.getActionId(),
                    String.format("Hello %s", Optional.ofNullable(data.getSayHelloTo()).orElse(featureConfig.getDefaultSayHelloTo()))));
            featureActionContext.getEventPublisher().publishCompletion(new SuccessActionCompleteEvent(featureActionContext.getActionId()));
        } catch(Exception ex) {
            featureActionContext.getEventPublisher().publishOutput(new DefaultActionOutputEvent(featureActionContext.getActionId(), OutputLevel.ERROR,
                            ex.getCause().getMessage(), System.nanoTime()));
            featureActionContext.getEventPublisher().publishCompletion(new FailureActionCompletion(featureActionContext.getActionId()));
        }

    }

    public Class<SayHelloFeatureActionData> getFeatureActionDataClass() {
        return SayHelloFeatureActionData.class;
    }
}
