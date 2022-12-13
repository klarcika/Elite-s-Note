package com.example.elitesnote.dao;
import com.example.elitesnote.razredi.Uporabnik;
import com.example.elitesnote.razredi.Skupina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkupinaRepository extends CrudRepository<Skupina, Long> {

    @Query("select s from Skupina s")
    List<Skupina> vrniSkupine(Skupina skupina);


        @Query("select s from Skupina s, Uporabnik u where u.skupina = s and s.stUporabnikov >= ?1")
        List<Uporabnik>  vrniSkupinoPoStUporabnikov(int stUporabnikov);


  //  select s from Skupina s, Uporabnik u where u.skupina = s and s.stUporabnikov >= ?1
}
