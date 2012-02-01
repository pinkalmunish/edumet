package com.edumet.models.User;

import java.io.Serializable;

public class UserInfo implements Serializable {
    
    private String firstname;
    public UserInfo() {
        super();
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }
}
