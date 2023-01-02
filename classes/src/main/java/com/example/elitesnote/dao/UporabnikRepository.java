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
    @Query(value = "SELECT ts.id, ts.naziv, t.id, t.registrska_stevilka FROM taksi t INNER JOIN taksi_sluzba ts ON t.sluzba_id=ts.id INNER JOIN taksist tak ON tak.sluzba_id=ts.id WHERE tak.ime=:ime", nativeQuery = true)
    List vrniTaksijeInSluzbe(String ime);
}
