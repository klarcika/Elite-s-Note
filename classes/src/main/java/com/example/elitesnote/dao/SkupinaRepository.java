package com.example.elitesnote.dao;

import com.example.elitesnote.razredi.Seznam;
import com.example.elitesnote.razredi.Skupina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkupinaRepository extends CrudRepository<Skupina, Long> {

    @Query("select s from Skupina s")
    List<Seznam> vrniSkupine(Skupina skupina);


        @Query("select s from Skupina s, Uporabnik u where u.skupina = s and s.stUporabnikov >= ?1")
        List<Skupina> vrniSkupine(String ime);

}
