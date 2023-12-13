package com.sheecode.project_api_web.exceptions;

public class userNotFoundException extends RuntimeException{
    public userNotFoundException(int id){
        super("Theres no such user by "+id);
    }
}
