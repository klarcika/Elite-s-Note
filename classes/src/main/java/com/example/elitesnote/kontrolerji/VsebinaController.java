package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.VsebinaRepository;
import com.example.elitesnote.razredi.Seznam;
import com.example.elitesnote.razredi.Uporabnik;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> izbrisiVsebino(@PathVariable(name = "id") Long id) {
        Optional<Vsebina> vsebina = vsebinaDao.findById(id);

        Vsebina vse = vsebina.get();
        vsebinaDao.delete(vse);
        return ResponseEntity.ok("izbrisano");
    }

    @PutMapping("/spremeni/id/{id}")
    public ResponseEntity<Vsebina> spremeniProfil(@PathVariable(name = "id") Long id, @RequestBody Vsebina podrobnosti){
        Optional<Vsebina> vsebina = vsebinaDao.findById(id);

        Vsebina vs = vsebina.get();
        vsebinaDao.delete(vs);
        vs = podrobnosti;

        vsebinaDao.save(vs);

        return ResponseEntity.ok(vs);
    }
}
