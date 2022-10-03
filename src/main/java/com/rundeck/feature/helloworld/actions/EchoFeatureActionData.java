package com.rundeck.feature.helloworld.actions;

public class EchoFeatureActionData {
    String echo;

    public EchoFeatureActionData() {
    }

    public EchoFeatureActionData(String echo) {
        this.echo = echo;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }
}
