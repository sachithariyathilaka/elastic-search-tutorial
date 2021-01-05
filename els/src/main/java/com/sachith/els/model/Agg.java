package com.sachith.els.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Agg {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("IPAddress")
    private String ipAddress;

    @JsonProperty("Id")
    private String id;

    public Agg() {
    }

    public Agg(String name, String ipAddress, String id) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
