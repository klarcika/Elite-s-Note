package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.UporabnikRepository;
import com.example.elitesnote.razredi.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UporabnikController {

    @Autowired
    private UporabnikRepository uporabnikDao;

    @PostMapping("/uporabnik")
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik uporabnik, @PathVariable(name = "id") Long id){
        return uporabnikDao.save(uporabnik);
    }
}