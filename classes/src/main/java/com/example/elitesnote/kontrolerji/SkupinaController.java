package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.SkupinaRepository;
import com.example.elitesnote.razredi.Administrator;
import com.example.elitesnote.razredi.Skupina;
import com.example.elitesnote.razredi.Uporabnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/skupina")
public class SkupinaController {

    @Autowired
    private SkupinaRepository skupinaDao;

    @GetMapping  //S1
    public Iterable<Skupina> vrniSkupine() {
        return skupinaDao.findAll();
    }

    @GetMapping("/skupina-id/{id}") //S1
    public Iterable<Skupina> vrniSkupino(@PathVariable(name = "naziv") Long id) {
        return skupinaDao.vrniSkupino(id);
    }

    @PostMapping("/dodaj")
    public Skupina setNaziv(@RequestBody Skupina naziv) {
        return skupinaDao.save(naziv);
    }

    @PostMapping("/dodaj_uporabnika/{id_uporabnik}") //S1
    public Iterable<Skupina> dodajUporabnika(@RequestBody Uporabnik uporabnik, @PathVariable(name = "id_uporabnik") Long id) {
        return skupinaDao.dodajUporabnika(uporabnik, id);
    }


    @DeleteMapping("/izbrisi/{id}") //S1
    public ResponseEntity<String> izbrisiSkupino(@PathVariable(name = "id") Long id) {
        Optional<Skupina> skupina = skupinaDao.findById(id);

        Skupina skup = skupina.get();
        skupinaDao.delete(skup);
        return ResponseEntity.ok("izbrisano");
    }

    @GetMapping("/stevilo_uporabnikov/{stUporabnikov}")
    public Iterable<Uporabnik> vrniSkupinoPoStUporabnikov(@PathVariable(name = "stUporabnikov") int stUporabnikov) {
        return skupinaDao.vrniSkupinoPoStUporabnikov(stUporabnikov);
    }


    @PostMapping("/dodaj_skupino/{id_uporabnik}")
    public Iterable<Skupina> dodajSkupino(@RequestBody String naziv) {
        return skupinaDao.dodajSkupino(naziv);
    }


    @GetMapping("/vrni_skupino") //1.sprint
    public Iterable<Skupina> vrniSkupino3() {
            return skupinaDao.vrniSkupino2();



    }
}