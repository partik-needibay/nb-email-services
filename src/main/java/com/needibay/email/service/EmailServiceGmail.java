package com.needibay.email.service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceGmail implements EmailService  {

    @Autowired
    private JavaMailSender javaMailSender;

    private String sender;

    private String process;

    @Autowired
    public EmailServiceGmail(){
    }


    @Override
    public void send(String email, String subjectLine, String template, Object data) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {
            helper.setTo(email);
            helper.setSubject(subjectLine);
            String htmlContent = process;
            helper.setText(htmlContent, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // Handle exception
        }
    }

    @Override
    public void setJavaMailSender(JavaMailSender jms){
        javaMailSender = jms;
    }

    @Override
    public void setProcess(String emailBodyContent){
        process = emailBodyContent;
    }

}
