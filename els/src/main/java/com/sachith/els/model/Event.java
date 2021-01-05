package com.sachith.els.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {

    @JsonProperty("Topic")
    private String topic;

    @JsonProperty("Params")
    private Params params;

    public Event() {
    }

    public Event(String topic, Params params) {
        this.topic = topic;
        this.params = params;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }
}
