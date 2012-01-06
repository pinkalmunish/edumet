package com.edumet.portal.login;


import com.edumet.portal.config.DatabaseTemplate;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;


import java.math.BigInteger;

import java.security.SecureRandom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.naming.*;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.jdbc.core.JdbcTemplate;


public class ForgottenPasswordPage {

    private String username;

    public ForgottenPasswordPage() {
        super();
    }

    public String getusername() {

        return username;

    }


    public void setusername(String userName) {

        this.username = userName;

    }


    public String emailPassword() throws NamingException, AddressException, NoSuchProviderException,
                                         MessagingException {

        String newPass = getRandomString();
        if (!usernameExists()) {
            FacesContext.getCurrentInstance().addMessage("forgottenPass",
                                                         new FacesMessage("Could not find such username"));

            return "failure";
        }
        updateTableWithNewPass(newPass);
        //sendEmail(newPass);

        return "success";

    }

    private void sendEmail(String newPass) throws NamingException, AddressException, NoSuchProviderException,
                                                  MessagingException {
        javax.naming.InitialContext ctx = new javax.naming.InitialContext();

        javax.mail.Session mail_session = (javax.mail.Session)ctx.lookup("EdumetMail");
        MimeMessage msg = new MimeMessage(mail_session);

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));

        msg.setFrom(new InternetAddress("pinkal.shah@gmail.com"));

        msg.setSubject("Important message from Edumet");

        msg.setText("Your password is:  " + newPass);


        Store store = mail_session.getStore();

        store.connect();

        Folder f = store.getFolder("Sent");

        if (!f.exists())
            f.create(Folder.HOLDS_MESSAGES);

        f.appendMessages(new Message[] { msg });

        Transport.send(msg);
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

        List rs = conn.queryForList("select * from portal_user p where p.username = '" + username + "'");
        if (!rs.isEmpty()) {
            return true;
        }

        return false;
    }


}
