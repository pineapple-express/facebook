package com.bancvue.facebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FacebookPocApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FacebookPocApplication.class, args);
        Message m = context.getBean(Message.class);
        m.sendMessage();
    }
}
