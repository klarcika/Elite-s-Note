package com.example.elitesnote.kontrolerji;
import com.example.elitesnote.razredi.Skupina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
@RestController
@RequestMapping
public class SkupinaController {

    @Autowired
    private SkupinaController skupinaDao;

   /*@GetMapping
    public Iterable<Skupina> vrniHise(){
        return skupinaDao.findAll();
    }

    */
    @GetMapping("/skupina")
    public Iterable<Skupina> vrniSkupine(){
        return skupinaDao.findAll();
    }

    @PostMapping
    public Skupina ustvariSkupino(@RequestBody String imeSkupine){
        return skupinaDao.save(imeSkupine);
    }

}
