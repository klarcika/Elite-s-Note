package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.UporabnikRepository;
import com.example.elitesnote.razredi.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("uporabnik")
public class UporabnikController {

    @Autowired
    private UporabnikRepository uporabnikDao;

    @PostMapping("/uporabnik")
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik uporabnik, @PathVariable(name = "id") Long id){
        return uporabnikDao.save(uporabnik);
    }

    @GetMapping
    public Iterable<Uporabnik> vrniUporabnika(){
        return uporabnikDao.findAll();
    }


  /*  @GetMapping("/uporabnik/{uporabniskoIme}")
    public Iterable<Uporabnik> vrniUporabnika(@PathVariable(name = "uporabniskoIme")String uporabniskoIme){
        return uporabnikDao.vrniUporabnika(uporabniskoIme);
    }*/


}
