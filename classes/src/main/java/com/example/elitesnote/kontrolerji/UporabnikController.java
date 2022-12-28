package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.UporabnikRepository;
import com.example.elitesnote.razredi.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/s_seznami_in_skupinami/{ime}/{stSeznamov}/{stSkupin}")
    public Iterable<Uporabnik> uporabnikiSSeznamiInSkupinami(@PathVariable("ime") String ime, @PathVariable("stSeznamov") int stSeznamov,
                                                             @PathVariable("stSkupin") int stSkupin){
        return uporabnikDao.seznamiInSkupine(ime, stSeznamov, stSkupin);
    }

    @PutMapping("/profil_spremeni/id/{id}")
    public ResponseEntity<Uporabnik> spremeniProfil(@PathVariable(name = "id") Long id, @RequestBody Uporabnik podrobnosti){
        Optional<Uporabnik> profil = uporabnikDao.findById(id);

        Uporabnik pr = profil.get();
        pr = podrobnosti;

        uporabnikDao.save(pr);

        return ResponseEntity.ok(pr);
    }
}
