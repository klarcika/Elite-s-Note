package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.ProfilRepository;
import com.example.elitesnote.razredi.Profil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class ProfilController {

    @Autowired
    private ProfilRepository profilDao;

    @GetMapping("/profil/{id}")
    public Optional<Profil> vrniProfil(@PathVariable(name = "id") Long id){
        return profilDao.findById(id);
    }

    @PutMapping("/profil/{id}")
    public ResponseEntity<Profil> spremeniProfil(@PathVariable(name = "id") Long id, @RequestBody Profil podrobnosti){
        Optional<Profil> profil = profilDao.findById(id);

        Profil pr = profil.get();
        pr.setProfilnaSlika(podrobnosti.getProfilnaSlika());
        pr.setGeslo(podrobnosti.getUporabnik().getGeslo());
        pr.setUporabniskoIme(podrobnosti.getUporabnik().getUporabniskoIme());

        profilDao.save(pr);

        return ResponseEntity.ok(pr);
    }
}
