package com.edumet.portal.login;


import com.edumet.models.User.UserInfo;
import com.edumet.portal.config.DatabaseTemplate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

        Connection conn=null;
        log.warn("Calling Authetnicate User");
        try {

            conn = DatabaseTemplate.getConnection();
            String query =
                "select * from web_users wu where wu.user_name = '" +
                userName + "' and wu.password =  '" + password + "'";
            log.info("Executing this query " + query);
            ResultSet rs = conn.createStatement().executeQuery(query);
            if (rs.next()) {
//                    String first_name = rs.getString("FIRST_NAME");
//                    prepareUserSession(first_name);
                DatabaseTemplate.closeConnection(conn);
                return "EmployeeDashBoard.html?faces-redirect=true";

            }
            DatabaseTemplate.closeConnection(conn);
            FacesContext.getCurrentInstance().addMessage("loginform",
                                                         new FacesMessage("Username/Password is incorrect"));

        } catch (SQLException se) {
            DatabaseTemplate.closeConnection(conn);
            log.error(se, se);


        }
        return "failure";

    }

    private void prepareUserSession(String name) {
        String attName = "UserInfo";
        UserInfo reqdObj = new UserInfo();
        reqdObj.setFirstname(name);

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(false);
        httpSession.setAttribute(attName, reqdObj);
    }


}
