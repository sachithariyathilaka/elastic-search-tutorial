package com.sachith.els.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "data")
public class Data {
    private int id;

    @Field
    @JsonProperty("Timestamp")
    private String timestamp;

    @Field
    @JsonProperty("MessageType")
    private String messageType;

    @Field
    @JsonProperty("Node")
    private Node node;

    @Field
    private String nameNode;

    @Field
    private String aggName;

    @Field
    private String topic;

    @Field
    private String device;

    @Field
    private String category;

    @Field
    @JsonProperty("Agg")
    private Agg agg;

    @Field
    @JsonProperty("Event")
    private Event event;

    public Data() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Agg getAgg() {
        return agg;
    }

    public void setAgg(Agg agg) {
        this.agg = agg;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getAggName() {
        return aggName;
    }

    public void setAggName(String aggName) {
        this.aggName = aggName;
    }

    public String getNameNode() {
        return nameNode;
    }

    public void setNameNode(String nameNode) {
        this.nameNode = nameNode;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
