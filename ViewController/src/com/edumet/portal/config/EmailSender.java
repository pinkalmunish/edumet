package com.edumet.portal.config;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


public class EmailSender {

    private JavaMailSender mailSender;
    private static final Logger log = Logger.getLogger(EmailSender.class);
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public static void sendPassword(String tempPassword, 
                                    String username) {

        try {
            log.info("sendPassword: attempting to send email to "+username);
            JavaMailSenderImpl sender = new JavaMailSenderImpl();
            //sender.setHost("216.167.203.226");
            sender.setHost("mail.edumet.com");
            sender.setUsername("munish@edumet.com");
            sender.setPassword("munish");
            sender.setProtocol("smtp");
            sender.setPort(25);
             
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(username);
            helper.setText("Your temporary Password is "+tempPassword);

            sender.send(message);
            log.info("sendPassword: message sent to "+username);
        } catch (MessagingException me) {
            log.error(me,me);
            me.printStackTrace();
        }
    }

    private boolean validateEmailAddressFormat(String username) {
        return true;
    }
}

