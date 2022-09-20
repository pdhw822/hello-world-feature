package com.rundeck.feature.helloworld;

import com.rundeck.feature.api.Feature;
import com.rundeck.feature.api.action.FeatureAction;
import com.rundeck.feature.helloworld.actions.SayHelloFeatureAction;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Component
public class HelloWorldFeature implements Feature<HelloWorldFeatureConfig> {
    boolean enabled = true;
    boolean running = false;

    Map<String, FeatureAction<?>> features = Map.of(SayHelloFeatureAction.ACTION, new SayHelloFeatureAction());
    HelloWorldFeatureConfig config = new HelloWorldFeatureConfig();
    public String getName() {
        return "hello-world";
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isRunning() {
        return running;
    }

    public void enable() {
        enabled = true;
    }

    public void disable() {
        enabled = false;
    }

    public void start() {

    }

    public void stop() {

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
