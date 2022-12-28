package com.example.elitesnote.dao;
import com.example.elitesnote.razredi.Skupina;
import com.example.elitesnote.razredi.Seznam;
import com.example.elitesnote.razredi.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long> {

    /*@Query("select imeSeznama from Uporabnik u where u.seznam.naziv= imeSeznama ")
    List<Seznam> vrniSezname(String imeSeznama);

    @Query("select u from Uporabnik")List<Uporabnik> vrniUporabnika();


    @Query("select s from Skupina s, Uporabnik u where u.skupina= s")
    List<Skupina> vrniSkupine();


    //2. sprint
    @Query("select u Uporabnik u, Skupina s where u.stSkupin>?1")
    List<Uporabnik> vrniStSkupinUporabnika();

     */

    @Query("select u from Uporabnik u where u.stSeznamov > ?1")
    List<Uporabnik> vrniStSeznamovUporabnika();
    //uporabnik ki ima več kot 3 sezname

    @Query("select u from Uporabnik u where u.uporabniskoIme = ?1 and u.stSeznamov > 0 and u.stSkupin > 0")
    List<Uporabnik> seznamiInSkupine(String ime, int stSeznamov,  int stSkupin);
    //2. sprint
    @Query("select u from Uporabnik u inner join Seznam s ON uporabnik.id =  seznam.id where s.imeSeznama like 'A%' ")
    Uporabnik vrniUporabnika();
}
