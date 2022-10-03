package com.rundeck.feature.helloworld.actions;

import com.rundeck.feature.api.action.FeatureAction;
import com.rundeck.feature.api.context.ContextKeys;
import com.rundeck.feature.api.context.FeatureActionContext;
import com.rundeck.feature.api.model.CompletionStatus;
import com.rundeck.feature.api.output.OutputLevel;
import com.rundeck.feature.helloworld.DefaultActionOutputEvent;
import com.rundeck.feature.helloworld.HelloWorldFeatureConfig;

import java.util.Optional;

public class SayHelloFeatureAction implements FeatureAction<SayHelloFeatureActionData> {
    public static final String ACTION = "say-hello";
    public String getName() {
        return ACTION;
    }

    @Override
    public String getDescription() {
        return "Says Hello to a provided name in the logs";
    }

    public CompletionStatus execute(final FeatureActionContext featureActionContext) {
        try {
            SayHelloFeatureActionData data = featureActionContext.get(ContextKeys.ACTION_DATA, SayHelloFeatureActionData.class);
            if(data == null) data = new SayHelloFeatureActionData();
            HelloWorldFeatureConfig featureConfig = featureActionContext.get(ContextKeys.FEATURE_CONFIG, HelloWorldFeatureConfig.class);
            if(featureConfig == null) featureConfig = new HelloWorldFeatureConfig();
            featureActionContext.getEventPublisher().publishOutput(new DefaultActionOutputEvent(featureActionContext.getActionId(),
                    String.format("Hello %s", Optional.ofNullable(data.getSayHelloTo()).orElse(featureConfig.getDefaultSayHelloTo())), featureActionContext.getUser()));
            return CompletionStatus.SUCCESS;
        } catch(Exception ex) {
            featureActionContext.getEventPublisher().publishOutput(new DefaultActionOutputEvent(featureActionContext.getActionId(), OutputLevel.ERROR,
                            ex.getCause().getMessage(), featureActionContext.getUser(), System.nanoTime()));
            return CompletionStatus.ERROR;
        }

    }

    public Class<SayHelloFeatureActionData> getFeatureActionDataClass() {
        return SayHelloFeatureActionData.class;
    }

    @Override
    public SayHelloFeatureActionData getSampleActionData() {
        return SAMPLE;
    }

    public static final SayHelloFeatureActionData SAMPLE = new SayHelloFeatureActionData("World!");
}
