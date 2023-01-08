package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.SeznamRepository;
import com.example.elitesnote.razredi.Seznam;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seznami")
public class SeznamController {

    @Autowired
    private SeznamRepository seznamDao;

    @GetMapping("/vsiSeznami")
    public Iterable<Seznam> vrniSezname(){
        return seznamDao.findAll();
    }

    // Sprint 1; izpis enega zapisa
    @GetMapping("/zanr/{zanr}")
    public Iterable<Seznam> vrniPoZanruVsebin(@PathVariable(name = "zanr") String zanr) {
        return seznamDao.vrniPoZanru(zanr);
    }

    // Sprint 1; dodajanje zapisa
    @PostMapping("/dodajSeznam")
    public boolean dodajSeznam(@RequestBody Seznam seznam){
        seznamDao.save(seznam);
        return true;
    }

    // Sprint 1; brisanje podatkov zapisa
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> izbrisiSeznam(@PathVariable(name = "id") Long id) {
        Optional<Seznam> seznam = seznamDao.findById(id);

        Seznam sez = seznam.get();
        seznamDao.delete(sez);
        return ResponseEntity.ok("izbrisano");
    }

    // Sprint 2; poizvedba z 2 modeloma
    @GetMapping("/uporabnik/{ime}")
    public Iterable<Seznam> vrniVsebineOdSeznama(@PathVariable(name = "ime") String ime){
        return seznamDao.seznamiOdUporabnika(ime);
    }

    // Sprint 3; poizvedba s 3 modeli
    @GetMapping("/ime/{ime}")
    public List vrniSeznamUporabnikaVsebino(@PathVariable(name = "ime") String ime){
        return seznamDao.seznamUporabnikVsebina(ime);
    }

    // Sprint 3; poizvedba s 4 modeli
    @GetMapping("/uporabnik_in_admin/{ime}")
    public List vrniUporabnikaVsebinoAdmina(@PathVariable(name = "ime") String ime){
        return seznamDao.uporabnikVsebinaAdmin(ime);
    }

    //2. sprint
    @GetMapping("/seznami_uporabnika/{id}")
    public Iterable<Seznam> seznami(@PathVariable(name = "id") Long id){
        return seznamDao.seznami(id);
    }
}