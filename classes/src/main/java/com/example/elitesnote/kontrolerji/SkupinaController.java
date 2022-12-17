package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.SkupinaRepository;
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
    @Autowired
    private UporabnikController uporabnikDao;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
   @GetMapping
   public Iterable<Skupina> vrniSkupine(){
       return skupinaDao.findAll();
   }

  /*  @PostMapping
    public Skupina ustvariSkupino(@RequestBody String imeSkupine){
        return skupinaDao.save(imeSkupine);
    }
   */
    @GetMapping("/stUporabnikov-skupina/{stUporabnikov}")
    public Iterable<Uporabnik> vrniSkupinoPoStUporabnikov(@PathVariable(name = "stUporabnikov") int stUporabnikov){
        return skupinaDao.vrniSkupinoPoStUporabnikov(stUporabnikov);
    }
    @PostMapping("/{id_uporabnik}")
    public Iterable<Skupina> dodajUporabnika(@RequestBody Uporabnik uporabnik, @PathVariable(name = "id_uporabnik") Long id){
    return skupinaDao.dodajUporabnika(uporabnik,id);
    }
    @DeleteMapping("skupina/{id}")
    public ResponseEntity<String> izbrisiSkupino(@PathVariable(name = "id") Long id){
        Optional<Skupina> skupina = skupinaDao.findById(id);

        Skupina skup = skupina.get();
        skupinaDao.delete(skup);
        return ResponseEntity.ok("izbrisano");
    }


}
