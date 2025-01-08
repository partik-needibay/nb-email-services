package com.needibay.email.service;

import com.needibay.email.dto.EmailDTO;
import com.needibay.email.repository.ConfigurationRepo;
import com.needibay.email.entity.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmailServiceProcessor {

    @Autowired
    ConfigurationRepo configurationRepo;

    @Autowired
    private JavaMailSender javaMailSender;

    private final TemplateEngine templateEngine;

    @Autowired
    EmailService emailService;

    @Autowired
    public EmailServiceProcessor(ConfigurationRepo theConfigurationRepo, EmailService theEmailService, TemplateEngine theTemplateEngine){
        configurationRepo = theConfigurationRepo;
        emailService = theEmailService;
        templateEngine = theTemplateEngine;
    }

    // Fetch selected admin configuration

    public void send(EmailDTO emailDTO) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Map<String, String> map = new HashMap<String, String>();
        map = (Map<String, String>) emailDTO.getVariableData();
        Context context = this.createContext(map);

        String process = templateEngine.process(emailDTO.getTemplate(),context);
        Configuration config = configurationRepo.findByConfigKey("EMAIL_SERVICE");

        Class c1 = Class.forName("com.needibay.email.service." + config.getConfigValue());

        EmailService emailService = (EmailService) c1.getDeclaredConstructor().newInstance();

        emailService.setJavaMailSender(javaMailSender);
        emailService.setProcess(process);
        emailService.send(emailDTO.getEmail(), emailDTO.getSubjectLine(), emailDTO.getTemplate(), emailDTO.getVariableData());
    }

    private Context createContext(Map<String, String> variables) {
        Context context = new Context();

        if (variables != null) {
            for (Map.Entry<String, String> entry : variables.entrySet()) {
                context.setVariable(entry.getKey(), entry.getValue());
            }
        }

        return context;
    }


}
