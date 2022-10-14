package com.java.intuit.user.userauthentication.models;

import java.util.HashMap;
import java.util.Map;

public class Session {


    private static Session instance;

    public Map<String, String> map;

    private Session(){
        this.map = new HashMap<>();
    }

    public static Session getInstance(){
        if(instance == null) {
            instance = new Session();
        }
        return instance;
    }
}
