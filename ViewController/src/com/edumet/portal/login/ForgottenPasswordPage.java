package com.edumet.portal.login;


import com.edumet.portal.config.DatabaseTemplate;
import com.edumet.portal.config.EmailSender;

import java.math.BigInteger;

import java.security.SecureRandom;

import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.jdbc.core.JdbcTemplate;


public class ForgottenPasswordPage {

    private String username;
    private Logger log = Logger.getAnonymousLogger();

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
        JdbcTemplate conn = DatabaseTemplate.getConnection();
        conn.execute("update portal_user p set p.password = '" + newPass + "' where p.username = '" + username + "'");

        return true;
    }

    private boolean usernameExists() {
        JdbcTemplate conn = DatabaseTemplate.getConnection();
        return true;

        //        List rs = conn.queryForList("select * from portal_user p where p.username = '" + username + "'");
        //        conn.query
        //        if (!rs.isEmpty()) {
        //            return true;
        //        }
        //
        //        return false;
    }


}
