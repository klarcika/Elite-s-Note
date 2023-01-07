package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.AdministratorRepository;
import com.example.elitesnote.razredi.Administrator;
import com.example.elitesnote.razredi.Skupina;
import com.example.elitesnote.razredi.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorRepository adminDao;

    // 2. sprint
    @GetMapping("/vsiAdmini")
    public Iterable<Administrator> vrniAdmin(){
        return adminDao.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Administrator> vrniAdmina(@PathVariable(name="id") Long id) {
        return adminDao.findById(id);
    }

    @PostMapping("/dodajAdministratorja")
    public Administrator dodajAdmina(@RequestBody Administrator admin) {
        return adminDao.save(admin);
    }

    @PutMapping("/spremeni/{id}")
    public Administrator spremeniAdmina(@PathVariable(name="id") Long id, @RequestBody Administrator admin) {

        if (!adminDao.existsById(id))
            return null;

        admin.setId(id);
        return adminDao.save(admin);
    }

    @DeleteMapping("/zbrisi/{id}")
    public Boolean izbrisiAdministratorja(@PathVariable(name="id") Long id) {

        if(!adminDao.existsById(id))
            return false;
        adminDao.deleteById(id);
        return true;
    }





}
