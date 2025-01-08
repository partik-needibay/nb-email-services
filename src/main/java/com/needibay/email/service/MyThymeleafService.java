package com.needibay.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class MyThymeleafService {

    @Autowired
    private JavaMailSender javaMailSender;

    private final TemplateEngine templateEngine;

    @Autowired
    public MyThymeleafService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public TemplateEngine getTemplateEngineInstance(){
        return this.templateEngine;
    }

    public void testingInstance(){
        Context context = new Context();

        String process = templateEngine.process("email-otp-verification",context);
        //context.setVariable("message", data);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {
            helper.setTo("gaurav@stackwit.com");
            helper.setSubject("subjectLine");
            String htmlContent = process;
            helper.setText(htmlContent, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // Handle exception
        }
    }

    // Your service methods
}
