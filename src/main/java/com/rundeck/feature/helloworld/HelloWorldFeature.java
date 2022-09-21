package com.rundeck.feature.helloworld;

import com.rundeck.feature.api.Feature;
import com.rundeck.feature.api.action.FeatureAction;
import com.rundeck.feature.helloworld.actions.SayHelloFeatureAction;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Component
public class HelloWorldFeature implements Feature<HelloWorldFeatureConfig> {
    boolean enabled = true;

    Map<String, FeatureAction<?>> features = Map.of(SayHelloFeatureAction.ACTION, new SayHelloFeatureAction());
    HelloWorldFeatureConfig config = new HelloWorldFeatureConfig();
    public String getName() {
        return "hello-world";
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void enable() {
        enabled = true;
    }

    public void disable() {
        enabled = false;
    }

    @Override
    public void cleanup() {

    }

    public Collection<FeatureAction<?>> getActions() {
        return features.values();
    }

    public Optional<FeatureAction<?>> getActionByName(String featureName) {
        return Optional.ofNullable(features.get(featureName));
    }

    public void configure(HelloWorldFeatureConfig helloWorldFeatureConfig) {
        this.config = helloWorldFeatureConfig;
    }

    @Override
    public HelloWorldFeatureConfig getConfiguration() {
        return config;
    }

    public Class<HelloWorldFeatureConfig> getConfigClass() {
        return HelloWorldFeatureConfig.class;
    }
}
