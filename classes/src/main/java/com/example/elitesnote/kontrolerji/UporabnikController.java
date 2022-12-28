package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.UporabnikRepository;
import com.example.elitesnote.razredi.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uporabnik")
public class UporabnikController {

    @Autowired
    private UporabnikRepository uporabnikDao;

    @PostMapping("/dodaj_uporabnika")
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik uporabnik){
        return uporabnikDao.save(uporabnik);
    }

    @GetMapping
    public Iterable<Uporabnik> vrniUporabnika(){
        return uporabnikDao.findAll();
    }

    @GetMapping("/stevilo_seznamov/{stSeznam}")
    public Iterable<Uporabnik> vrniStSeznamovUporabnika(@PathVariable(name = "stSeznam") int stSeznamov){
        return uporabnikDao.vrniStSeznamovUporabnika();
    }



}
