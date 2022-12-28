package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.SeznamRepository;
import com.example.elitesnote.razredi.Seznam;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/seznami")
public class SeznamController {

    @Autowired
    private SeznamRepository seznamDao;

    @GetMapping
    public Iterable<Seznam> vrniSezname(){
        return seznamDao.findAll();
    }

    @GetMapping("/zanr/{zanr}")
    public Iterable<Seznam> vrniPoZanruVsebin(@PathVariable(name = "zanr") String zanr){
        return seznamDao.vrniPoZanru(zanr);
    }

    @GetMapping("/uporabnik/{uporabnikovId}")
    public Iterable<Seznam> vrniUporabnikoveSezname(@PathVariable(name = "id") Long id){
        return seznamDao.uporabnikoviSeznami(id);
    }

    @GetMapping("/uporabnik_in_vsebina/{uporabnikovId}&{naslovVsebine}")
    public Vsebina vsebinaIzSeznama(@PathVariable(name = "id") Long id, @RequestBody String naslov){
        return seznamDao.vsebinaIzUporSeznama(id, naslov);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> izbrisiSeznam(@PathVariable(name = "id") Long id){
        Optional<Seznam> seznam = seznamDao.findById(id);

        Seznam sez = seznam.get();
        seznamDao.delete(sez);
        return ResponseEntity.ok("izbrisano");
    }
}
