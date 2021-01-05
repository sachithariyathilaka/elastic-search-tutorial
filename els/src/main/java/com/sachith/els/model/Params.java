package com.sachith.els.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Params {

    @JsonProperty("NvrUuid")
    private String nvrUuid;

    @JsonProperty("DeviceId")
    private String deviceId;

    @JsonProperty("DeviceName")
    private String deviceName;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Category")
    private String category;

    @JsonProperty("LinkMode")
    private String linkMode;

    @JsonProperty("LinkedEventType")
    private String linkedEventType;

    @JsonProperty("Message")
    private String message;

    public Params() {
    }

    public String getNvrUuid() {
        return nvrUuid;
    }

    public void setNvrUuid(String nvrUuid) {
        this.nvrUuid = nvrUuid;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLinkMode() {
        return linkMode;
    }

    public void setLinkMode(String linkMode) {
        this.linkMode = linkMode;
    }

    public String getLinkedEventType() {
        return linkedEventType;
    }

    public void setLinkedEventType(String linkedEventType) {
        this.linkedEventType = linkedEventType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
