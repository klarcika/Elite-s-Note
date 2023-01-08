package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.razredi.EmailService;
import com.fasterxml.jackson.core.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/posljiMail")
public class EmailController {

    @Autowired
    private EmailService emailDao;

    @PostMapping("/poslji")
    public boolean poslji(@RequestBody Map<String, Object> podatki){
        System.out.println(podatki);
        return emailDao.posljiMail(podatki.get("recipient").toString(), podatki.get("subject").toString(), podatki.get("body").toString());
    }
}
