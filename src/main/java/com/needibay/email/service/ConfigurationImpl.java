package com.needibay.email.service;

import com.needibay.email.repository.ConfigurationRepo;
import com.needibay.email.entity.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationImpl implements Config {

    @Autowired
    ConfigurationRepo configurationRepo;

    public ConfigurationImpl(ConfigurationRepo theConfigurationRepo){
        configurationRepo = theConfigurationRepo;
    }

    @Override
    public Configuration findByOptionKey(String optionKey) {

        return configurationRepo.findByConfigKey(optionKey);
    }



}
