package com.rundeck.feature.helloworld.actions;

public class SayHelloFeatureActionData {
    String sayHelloTo;

    public SayHelloFeatureActionData() {
    }

    public SayHelloFeatureActionData(String sayHelloTo) {
        this.sayHelloTo = sayHelloTo;
    }

    public String getSayHelloTo() {
        return sayHelloTo;
    }

    public void setSayHelloTo(String sayHelloTo) {
        this.sayHelloTo = sayHelloTo;
    }
}
