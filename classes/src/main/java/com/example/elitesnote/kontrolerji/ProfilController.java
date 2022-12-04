package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.ProfilRepository;
import com.example.elitesnote.razredi.Profil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class ProfilController {

    @Autowired
    private ProfilRepository profilDao;

    @GetMapping("/profil/id")
    public Optional<Profil> vrniProfil(@PathVariable(name = "id") Long id){
        return profilDao.findById(id);
    }
}
