package com.decode9.inventory.utils;

import javax.persistence.Entity;

public class ApiResponse{

    private String message;
    private Object data;

    public ApiResponse(String message, Object data){
        this.data = data;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setData(Entity data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}