package com.edumet.portal.config;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


public class EmailSender {

    private JavaMailSender mailSender;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public static void sendPassword(String tempPassword, 
                                    String username) {

        try {
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
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    private boolean validateEmailAddressFormat(String username) {
        return true;
    }
}

