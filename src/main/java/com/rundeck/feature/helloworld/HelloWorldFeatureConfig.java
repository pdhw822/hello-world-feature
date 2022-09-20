package com.rundeck.feature.helloworld;

public class HelloWorldFeatureConfig {
    String defaultSayHelloTo = "World";

    public String getDefaultSayHelloTo() {
        return defaultSayHelloTo;
    }

    public void setDefaultSayHelloTo(String defaultSayHelloTo) {
        this.defaultSayHelloTo = defaultSayHelloTo;
    }
}
