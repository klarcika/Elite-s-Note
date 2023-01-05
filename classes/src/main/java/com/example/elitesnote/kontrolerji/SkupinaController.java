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

   // 1. sprint
   @GetMapping
   public Iterable<Skupina> vrniSkupine(){
       return skupinaDao.findAll();
   }

    @GetMapping("/skupina-id/{id}")
    public Iterable<Skupina> vrniSkupino(@PathVariable(name = "naziv") Long id){
        return skupinaDao.vrniSkupino(id);
    }

    @PostMapping("/dodaj")
    public Skupina setNaziv(@RequestBody Skupina naziv) {
        return skupinaDao.save(naziv);
    }
    @PostMapping("/dodajSkupino")
    public Skupina dodajSkupino(@RequestBody Skupina skupina) {
        return skupinaDao.save(skupina);
    }

    @DeleteMapping("/izbrisi/{id}") //S1
    public ResponseEntity<String> izbrisiSkupino(@PathVariable(name = "id") Long id){
        Optional<Skupina> skupina = skupinaDao.findById(id);

        Skupina skup = skupina.get();
        skupinaDao.delete(skup);
        return ResponseEntity.ok("izbrisano");
    }

    @GetMapping("/stevilo_uporabnikov/{stUporabnikov}")
    public Iterable<Skupina> vrniSkupinoPoStUporabnikov(@PathVariable(name = "stUporabnikov") int stUporabnikov){
        return skupinaDao.vrniSkupinoPoStUporabnikov(stUporabnikov);
    }

   /* @PostMapping("/dodaj_skupino/{id_uporabnik}")
    public Iterable<Skupina> dodajSkupino(@RequestBody String naziv){
        return skupinaDao.save(naziv);
    }
    */
}
