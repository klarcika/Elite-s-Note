package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.VsebinaRepository;
import com.example.elitesnote.razredi.Uporabnik;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vsebine")
public class VsebinaController {

    @Autowired
    private VsebinaRepository vsebinaDao;

    @GetMapping
    public Iterable<Vsebina> vrniVsebine(){
        return vsebinaDao.findAll();
    }

    @GetMapping("/zanr/{zanr}/{naslov}")
    public Iterable<Vsebina> vsebinaZanr(@PathVariable("zanr") String zanr, @PathVariable("naslov") String naslov){
        return vsebinaDao.vsebinePoZanru(zanr, naslov);
    }

	@GetMapping("/administrator") //admin
	public Iterable<Vsebina> metodaSeznamVsebine(@PathVariable(name = "naslov") String naslov){
		return vsebinaDao.seznamVsebine(naslov);
	}

    @PostMapping("/dodajVsebino")
    public boolean dodajVsebino(@RequestBody Vsebina vsebina){
        vsebinaDao.save(vsebina);
        return true;
    }
}
