package com.sachith.els.dto;

import com.sachith.els.model.Data;

import java.util.List;

public class ResponseDto {
    private int pageNumber;
    private int status;
    private String message;
    private List<Data> data;

    public ResponseDto(int pageNumber, int status, List<Data> data, String message) {
        this.pageNumber = pageNumber;
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
