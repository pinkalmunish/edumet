package com.edumet.portal.login;


import com.edumet.portal.config.DatabaseTemplate;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;


public class LoginPage {

    private String userName;

    private String password;
    private final static Logger log = Logger.getLogger(LoginPage.class);

    //Constructor

    public LoginPage() {

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

        log.warn("Calling Authetnicate User");
        List rs = DatabaseTemplate.getConnection().queryForList("select * from web_users p where p.user_name = '" + userName +
                                                     "' and p.password =  '" + password + "'");
        if (!rs.isEmpty()) {
             
            return "EmployeeDashBoard.html?faces-redirect=true";
             
        }

        FacesContext.getCurrentInstance().addMessage("loginform", new FacesMessage("Username/Password is incorrect"));


        return "failure";
    }


}
