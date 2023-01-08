package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.VsebinaRepository;
import com.example.elitesnote.razredi.Seznam;
import com.example.elitesnote.razredi.Uporabnik;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vsebine")
public class VsebinaController {

    @Autowired
    private VsebinaRepository vsebinaDao;

    // Sprint 1; izpis vseh zapisov
    @GetMapping("/vseVsebine")
    public Iterable<Vsebina> vrniVsebine(){
        return vsebinaDao.findAll();
    }

    // Sprint 1; poizvedba z 2 parametroma
    @GetMapping("/zanr_in_naslov/{zanr}/{naslov}")
    public Iterable<Vsebina> vsebinaZanr(@PathVariable("zanr") String zanr, @PathVariable("naslov") String naslov){
        return vsebinaDao.vsebinePoZanru(zanr, naslov);
    }

	@GetMapping("/administrator") //admin
	public Iterable<Vsebina> metodaSeznamVsebine(@PathVariable(name = "naslov") String naslov){
		return vsebinaDao.seznamVsebine(naslov);
	}

    // Sprint 2
    @PostMapping("/dodajVsebino")
    public boolean dodajVsebino(@RequestBody Vsebina vsebina){
        vsebinaDao.save(vsebina);
        return true;
    }

    // Projekt/Sprint 1; poizvedba s 3 parametri
    @GetMapping("/naslov_in_zanr/{id}/{naslov}/{zanr}")
    public Vsebina vsebinaIzSeznama(@PathVariable("id") Long id, @PathVariable("naslov") String naslov, @PathVariable("zanr") String zanr) {
        return vsebinaDao.vsebinaNaslovZanr(id, naslov, zanr);
    }

    // Sprint 2
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> izbrisiVsebino(@PathVariable(name = "id") Long id) {
        Optional<Vsebina> vsebina = vsebinaDao.findById(id);

        Vsebina vse = vsebina.get();
        vsebinaDao.delete(vse);
        return ResponseEntity.ok("izbrisano");
    }

    // Sprint 2
    @PutMapping("/spremeni/id/{id}")
    public ResponseEntity<Vsebina> spremeniProfil(@PathVariable(name = "id") Long id, @RequestBody Vsebina podrobnosti){
        Optional<Vsebina> vsebina = vsebinaDao.findById(id);

        Vsebina vs = vsebina.get();
        vsebinaDao.delete(vs);
        vs = podrobnosti;

        vsebinaDao.save(vs);

        return ResponseEntity.ok(vs);
    }

    // Sprint 2; poizvedba z 2 modeloma
    @GetMapping("/seznam/{ime}")
    public Iterable<Vsebina> vrniVsebineOdSeznama(@PathVariable(name = "ime") String ime){
        return vsebinaDao.vsebineIzSeznama(ime);
    }

    // Sprint 3; poizvedba s 3 modeli
    @GetMapping("/naslov/{ime}")
    public List vrniVsebinoSeznamAdmina(@PathVariable(name = "ime") String ime){
        return vsebinaDao.vsebinaSeznamAdmin(ime);
    }
}
