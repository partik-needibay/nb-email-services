package com.needibay.email.service;

import org.springframework.mail.javamail.JavaMailSender;

public interface EmailService {

    public void send(String email, String subjectLine, String templateId, Object data);

    void setJavaMailSender(JavaMailSender javaMailSender);

    void setProcess(String emailBodyContent);
}
