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

    @GetMapping("/vseVsebine")
    public Iterable<Vsebina> vrniVsebine(){
        return vsebinaDao.findAll();
    }

    @GetMapping("/{zanr}/{naslov}")
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

    @GetMapping("/naslov_in_zanr/{id}/{naslov}/{zanr}")
    public Vsebina vsebinaIzSeznama(@PathVariable("id") Long id, @PathVariable("naslov") String naslov, @PathVariable("zanr") String zanr) {
        return vsebinaDao.vsebinaNaslovZanr(id, naslov, zanr);
    }
}
