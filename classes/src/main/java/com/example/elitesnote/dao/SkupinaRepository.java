package com.example.elitesnote.dao;
import com.example.elitesnote.razredi.Uporabnik;
import com.example.elitesnote.razredi.Skupina;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkupinaRepository extends CrudRepository<Skupina, Long> {
    /*@Query("select s from Skupina s")
        //vrne vse skupine?
    List<Skupina> vrniSkupine();

     */

    @Query("select s from Skupina s where s.id=?1") //vrne skupino ki ima določen id
    List<Skupina> vrniSkupino(Long id);

    @Query("select s from Skupina s, Uporabnik u where u.skupina = s and s.stUporabnikov >= ?1")
    List<Uporabnik> vrniSkupinoPoStUporabnikov(int stUporabnikov);
//vrne skupino ki ima stUporabnikov večje od 1
}