package com.needibay.email.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;
@Component
public class Utility {

    public UUID generateUniqueId() {
        return UUID.randomUUID();
    }

    public String getRandomDigit(){
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    public String generateSalt() {
        return BCrypt.gensalt(5);
    }

}
