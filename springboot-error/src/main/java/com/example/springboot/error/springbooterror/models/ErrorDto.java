package com.example.springboot.error.springbooterror.models;

import java.util.Date;

public class ErrorDto {
    
    private int statusCode;
    private String message;
    private Date date;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    } 
    
}
