package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.SkupinaRepository;
import com.example.elitesnote.razredi.Administrator;
import com.example.elitesnote.razredi.Skupina;
import com.example.elitesnote.razredi.Uporabnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/skupina")
public class SkupinaController {

    @Autowired
    private SkupinaRepository skupinaDao;

   // 1. sprint
   @GetMapping("/vseSkupine")
   public Iterable<Skupina> vrniSkupine(){
       return skupinaDao.findAll();
   }

   @GetMapping("/skupina-id/{id}")
    public Iterable<Skupina> vrniSkupino(@PathVariable(name = "naziv") Long id){
        return skupinaDao.vrniSkupino(id);
    }

    @PostMapping("/dodajSkupino")
    public Skupina dodajSkupino(@RequestBody Skupina skupina) {
        return skupinaDao.save(skupina);
    }

    @PutMapping("/spremeni/{id}")
    public Skupina spremeniSkupino(@PathVariable(name="id") Long id, @RequestBody Skupina skupina) {

        if (!skupinaDao.existsById(id))
            return null;

        skupina.setId(id);
        return skupinaDao.save(skupina);
    }
    @DeleteMapping("/izbrisi/{id}")
    public ResponseEntity<String> izbrisiSkupino(@PathVariable(name = "id") Long id){
        Optional<Skupina> skupina = skupinaDao.findById(id);

        Skupina skup = skupina.get();
        skupinaDao.delete(skup);
        return ResponseEntity.ok("izbrisano");
    }
    @GetMapping("/naziv/{naziv}/stUporabnikov/{stUporabnikov}")
    public Iterable<Skupina> vrniDolocenoSkupino(@PathVariable(name = "naziv") String naziv, @PathVariable(name = "stUporabnikov") int stUporabnikov ){
        return skupinaDao.vrniDolocenoSkupino(naziv, stUporabnikov);
    }

//3. sprint
@GetMapping("/imeSkupine/{naziv}")
public List vrniSkupinoInUporabnike(@PathVariable(name = "naziv") String naziv){
    return skupinaDao.vrniSkupinoInUporabnike(naziv);
}

}
