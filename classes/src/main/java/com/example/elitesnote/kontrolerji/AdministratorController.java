package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.AdministratorRepository;
import com.example.elitesnote.dao.VsebinaRepository;
import com.example.elitesnote.razredi.Administrator;
import com.example.elitesnote.razredi.Skupina;
import com.example.elitesnote.razredi.Uporabnik;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
@RequestMapping
public class AdministratorController {

    @Autowired
    private AdministratorRepository adminDao;

    /*@PostMapping("/administrator")
    public Administrator setAdminIme(@RequestBody Administrator adminIme) {
        return adminDao.save(adminIme);
    }
     */

    /*@PutMapping("/admin-update/{id}")
    public ResponseEntity<Skupina> updateAdmin(@PathVariable long id, @RequestBody Administrator administrator) {
        Administrator a= administrator.getId();

        a.setId(administrator.getId());
        a.setAdminIme(administrator.getAdminIme());

        return ResponseEntity.ok(updateAdmin);
    }
  */

    @GetMapping
    public Iterable<Administrator> vrniAdmin(){
        return adminDao.findAll();
    }

}
