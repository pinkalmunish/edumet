package com.edumet.portal.login;


import com.edumet.portal.config.DatabaseTemplate;
import com.edumet.portal.config.EmailSender;

import java.math.BigInteger;

import java.security.SecureRandom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;


public class ForgottenPasswordPage {

    private String username;
    private Logger log = Logger.getLogger(ForgottenPasswordPage.class);

    public ForgottenPasswordPage() {
        super();
    }

    public String getusername() {

        return username;

    }


    public void setusername(String userName) {

        this.username = userName;

    }


    public String emailPassword() {

        String newPass = getRandomString();
        if (!usernameExists()) {
            FacesContext.getCurrentInstance().addMessage("forgottenPass",
                                                         new FacesMessage("Could not find such username"));


            return "failure";
        }
        updateTableWithNewPass(newPass);
        sendEmail(newPass);

        return "success";

    }

    private void sendEmail(String newPass) {
        EmailSender.sendPassword(newPass, username);


    }


    private String getRandomString() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);

    }

    private boolean updateTableWithNewPass(String newPass) {
        Connection conn = null;
        try {
            conn = DatabaseTemplate.getConnection();
            Statement statement = conn.createStatement();
            statement.execute("update web_users p set p.password = '" + newPass + "' where p.user_name = '" +
                              username + "'");
            conn.commit();
            DatabaseTemplate.closeConnection(conn);
        } catch (SQLException se) {
            log.error(se, se);
            DatabaseTemplate.closeConnection(conn);
            return false;
        }

        return true;
    }

    private boolean usernameExists() {
        Connection connection = DatabaseTemplate.getConnection();
        try {
            ResultSet rs =
                connection.createStatement().executeQuery("select * from web_users where user_name = '" + username +
                                                          "'");
            if (rs.next()) {
                DatabaseTemplate.closeConnection(connection);
                return true;
            }
        } catch (SQLException se) {
            log.error(se, se);
            DatabaseTemplate.closeConnection(connection);
            return false;
        }
        DatabaseTemplate.closeConnection(connection);
        return false;


    }


}
