package com.example.elitesnote.dao;

import com.example.elitesnote.razredi.Seznam;
import com.example.elitesnote.razredi.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long> {

    @Query("select imeSeznama from Seznam, u Uporabnik where u.seznam= imeSeznama ")
    List<Seznam> vrniSezname(String imeSeznama);

    @Query("select uporabniskoIme from Uporabnik")List<Uporabnik> vrniImena(Uporabnik uporabnik);



}
