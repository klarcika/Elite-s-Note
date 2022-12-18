package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.VsebinaRepository;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class VsebinaController {

    @Autowired
    private VsebinaRepository vsebinaDao;

    @GetMapping("/vsebine")
    public Iterable<Vsebina> vrniVsebine(){
        return vsebinaDao.findAll();
    }

	@GetMapping("/seznamVsebine") //admin
	public Iterable<Vsebina> metodaSeznamVsebine(@PathVariable(name= "naslov") String naslov){
		return vsebinaDao.seznamVsebine(naslov);
	}
}
