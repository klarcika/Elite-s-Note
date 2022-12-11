package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.SeznamRepository;
import com.example.elitesnote.razredi.Seznam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class SeznamController {

    @Autowired
    private SeznamRepository  seznamDao;

    @GetMapping("/seznami")
    public Iterable<Seznam> vrniSezname(){
        return seznamDao.findAll();
    }

    @GetMapping("/seznami/{zanr}")
    public Iterable<Seznam> vrniPoZanruVsebin(@PathVariable(name = "zanr") String zanr){
        return seznamDao.vrniPoZanru(zanr);
    }

    @DeleteMapping("seznami/{id}")
    public ResponseEntity<String> izbrisiSeznam(@PathVariable(name = "id") Long id){
        Optional<Seznam> seznam = seznamDao.findById(id);

        Seznam sez = seznam.get();
        seznamDao.delete(sez);
        return ResponseEntity.ok("izbrisano");
    }
}
