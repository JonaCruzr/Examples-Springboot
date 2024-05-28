package com.springboot.webapp.springbootweb.models.dto;

public class ParamDto {
    private String message;
    private Integer code;

    public ParamDto(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ParamDto(){

    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage(){
        return message;
    }

    public Integer getCode() {
        return code;
    }

    
}
