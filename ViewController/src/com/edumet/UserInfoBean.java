package com.edumet;

import java.sql.ResultSet;
import java.sql.SQLException;

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

        try {
            ResultSet rs =
                DBConnector.getConnection().createStatement().executeQuery("select * from portal_user p where p.username = '" +
                                                                           userName + "' and p.password =  '" +
                                                                           password + "'");
            while (rs.next()) {
                return "success";
            }
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        } finally {

        }
        return "failure";
    }


}
