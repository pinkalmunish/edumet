package com.edumet;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UserInfoBean {

    private String userName;

    private String password;


    //Constructor

    public UserInfoBean() {

    }


    public String getPassword() {

        return password;

    }


    public void setPassword(String password) {

        this.password = password;

    }


    public String getUserName() {

        return userName;

    }


    public void setUserName(String userName) {

        this.userName = userName;

    }

    //Method to verify the user authentication


    public String SimpleAuthenticateUser() {


        List rs =
            DBConnector.getConnection().queryForList("select * from portal_user p where p.username = '" + userName +
                                                     "' and p.password =  '" + password + "'");
        if (!rs.isEmpty()) {
            return "success";
        }

        FacesContext.getCurrentInstance().addMessage("loginform", new FacesMessage("Username/Password is incorrect"));


        return "failure";
    }


}
