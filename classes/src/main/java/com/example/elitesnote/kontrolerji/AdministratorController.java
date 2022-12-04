package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.AdministratorRepository;
import com.example.elitesnote.razredi.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AdministratorController {

    @Autowired
    private AdministratorRepository adminDao;

    @GetMapping("/adminIme/{adminIme}")
    public Iterable<Administrator> vrniImenaAdminov(@PathVariable(name= "adminIme") String adminIme) {
        return (Iterable<Administrator>) adminDao;
    }

    @PostMapping //admin
    public Administrator setAdminIme(@RequestBody Administrator adminIme) {
        return adminDao.save(adminIme);
    }
}
