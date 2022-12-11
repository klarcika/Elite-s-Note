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

    @PostMapping("/administrator")
    public Administrator setAdminIme(@RequestBody Administrator adminIme) {
        return adminDao.save(adminIme);
    }
}
