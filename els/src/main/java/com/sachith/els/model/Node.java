package com.sachith.els.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.elasticsearch.annotations.Field;

public class Node {

    @Field
    @JsonProperty("Name")
    private String nodeName;

    @Field
    @JsonProperty("IPAddress")
    private String ipAddress;

    @Field
    @JsonProperty("Plugin")
    private String plugIn;

    public Node() {
    }

    public String getName() {
        return nodeName;
    }

    public void setName(String name) {
        this.nodeName = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPlugIn() {
        return plugIn;
    }

    public void setPlugIn(String plugIn) {
        this.plugIn = plugIn;
    }

    @Override
    public String toString(){
        return "Name: "+getName();
    }
}
