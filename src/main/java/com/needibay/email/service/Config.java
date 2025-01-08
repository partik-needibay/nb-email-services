package com.needibay.email.service;
import com.needibay.email.entity.Configuration;

public interface Config {
    public Configuration findByOptionKey(String optionKey);

}
