package com.ecommerce.backendAtHiit.exception;

import java.time.Instant;
import java.util.List;

public class ExceptionResponse<G> {
     private String message;
     private Instant timeStamp;
     private Integer status;
     private List<G> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<G> getData() {
        return data;
    }

    public void setData(List<G> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}
