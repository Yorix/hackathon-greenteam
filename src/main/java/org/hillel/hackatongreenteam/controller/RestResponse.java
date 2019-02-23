package org.hillel.hackatongreenteam.controller;

import javax.validation.constraints.NotNull;

public class RestResponse{

    @NotNull
    private int status;

    private String message;

    private Object data;

    public RestResponse() {}

    public RestResponse(int status, String message){
        this.status = status;
        this.message = message;
    }

    public RestResponse(int status, String message, Object data){
        this.status  = status;
        this.message = message;
        this.data    = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
