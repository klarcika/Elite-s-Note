package com.example.elitesnote.dao;
import com.example.elitesnote.razredi.Skupina;
import com.example.elitesnote.razredi.Seznam;
import com.example.elitesnote.razredi.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long> {

    @Query("select imeSeznama from Seznam, u Uporabnik where u.seznam= imeSeznama ")
    List<Seznam> vrniSezname(String imeSeznama);

    @Query("select u from Uporabnik")List<Uporabnik> vrniUporabnika();


    @Query("select s from Skupina s, u Uporabnik where u.skupina= s")
    List<Skupina> vrniSkupine();


    //2. sprint
    @Query("select u Uporabnik u, s Skupina where u.stSkupin>?3")
    List<Uporabnik> vrniStSkupinUporabnika();

    @Query("select u Uporabnik u, s Seznam where s.uporabnik=u and u.stSeznamov>?3")
    List<Uporabnik> vrniStSeznamovUporabnika();
    //uporabnik ki ima več kot 3 sezname
}
