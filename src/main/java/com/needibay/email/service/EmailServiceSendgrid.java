package com.needibay.email.service;

import org.springframework.mail.javamail.JavaMailSender;

public class EmailServiceSendgrid implements EmailService{

    @Override
    public void send(String email, String subjectLine, String templateId, Object data) {

    }

    @Override
    public void setJavaMailSender(JavaMailSender javaMailSender) {

    }

    @Override
    public void setProcess(String emailBodyContent) {

    }


}
