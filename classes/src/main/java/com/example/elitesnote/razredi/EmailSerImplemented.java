package com.example.elitesnote.razredi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;

@Component
public class EmailSerImplemented implements EmailService{

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public boolean posljiMail(String to, String zadeva, String besedilo) {
        try {
            SimpleMailMessage sporocilo = new SimpleMailMessage();
            sporocilo.setFrom("abhceoij8dwz32@gmail.com");
            sporocilo.setTo(to);
            sporocilo.setSubject(zadeva);
            sporocilo.setText(besedilo);
            emailSender.send(sporocilo);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
