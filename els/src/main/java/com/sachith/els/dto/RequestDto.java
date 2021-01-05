package com.sachith.els.dto;

public class RequestDto {
    private String freeText;
    private int pageNumber;
    private String nameNode;
    private String aggName;
    private String topic;
    private String device;
    private String category;
    private String fromDate;
    private String toDate;

    public RequestDto(String freeText, int pageNumber, String nodeName, String aggName, String topic, String device, String category, String fromDate, String toDate) {
        this.freeText = freeText;
        this.pageNumber = pageNumber;
        this.nameNode = nodeName;
        this.aggName = aggName;
        this.topic = topic;
        this.device = device;
        this.category = category;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getNodeName() {
        return nameNode;
    }

    public void setNodeName(String nodeName) {
        this.nameNode = nodeName;
    }

    public String getAggName() {
        return aggName;
    }

    public void setAggName(String aggName) {
        this.aggName = aggName;
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
}
