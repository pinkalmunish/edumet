package com.edumet;


import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;


import java.math.BigInteger;

import java.security.SecureRandom;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.*;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class RetrievePasswordBean {

    private String username;

    public RetrievePasswordBean() {
        super();
    }

    public String getusername() {

        return username;

    }


    public void setusername(String userName) {

        this.username = userName;

    }


    public void emailPassword() throws NamingException, AddressException, NoSuchProviderException, MessagingException {

        String newPass = getRandomString();
        updateTableWithNewPass(newPass);


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

    private void updateTableWithNewPass(String newPass) {
        Connection conn = DBConnector.getConnection();
        try {
            conn.createStatement().execute("update portal_user p set p.password = '" + newPass +
                                           "' where p.username = '" + username + "'");
            conn.commit();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


}
