package com.springboot.webapp.springbootweb.models.dto;

import com.springboot.webapp.springbootweb.models.User;

public class UserDto {

    private String title;
    private User user;

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }


}
