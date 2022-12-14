package com.example.elitesnote.dao;
import com.example.elitesnote.razredi.Skupina;
import com.example.elitesnote.razredi.Seznam;
import com.example.elitesnote.razredi.Uporabnik;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long> {


    @Query("SELECT u FROM Uporabnik u WHERE u.stSeznamov > ?1")
    List<Uporabnik> vrniStSeznamovUporabnika();
    //uporabnik ki ima več kot 3 sezname

    // Projekt/Sprint 1; poizvedba s 3 parametri
    @Query("SELECT u FROM Uporabnik u WHERE u.uporabniskoIme = ?1 and u.stSeznamov >= 0 and u.stSkupin >= 0")
    List<Uporabnik> seznamiInSkupine(String ime, int stSeznamov,  int stSkupin);

    // registracija
    @Query("SELECT u FROM Uporabnik u WHERE u.uporabniskoIme = :uporabniskoIme ")
    List<Uporabnik> preveriCeUporabnikObstaja(String uporabniskoIme);

    // prijava
    @Query("SELECT u FROM Uporabnik u WHERE u.geslo = ?1 AND u.uporabniskoIme = ?2")
    List<Uporabnik> vrniLogin(String geslo, String uporabniskoIme);

}
