package com.example.elitesnote.dao;

import com.example.elitesnote.razredi.Administrator;
import com.example.elitesnote.razredi.Seznam;
import com.example.elitesnote.razredi.Uporabnik;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeznamRepository extends CrudRepository<Seznam, Long> {

    @Query("select s from Seznam s, Vsebina v where v.seznam = s and v.zanr = ?1")
    List<Seznam> vrniPoZanru(String zanr);

    @Query("select s from Seznam s, Uporabnik u where s.uporabnik = u and u.id = ?1")
    List<Seznam> uporabnikoviSeznami(Long id);

    @Query("select v from Vsebina v, Seznam s, Uporabnik u where v.seznam = s and s.uporabnik = u and u.id = ?1 and v.naslov = ?2 and v.zanr = ?3")
    Vsebina vsebinaIzUporSeznama(Long id, String naslov, String zanr);
    @Query("select v from Vsebina v, Seznam s, Uporabnik u where v.seznam = s and s.uporabnik = u and u.id = ?1 and v.naslov = ?2")
    Vsebina vsebinaIzUporSeznama(Long id, String naslov);


    // 2 sprint
    @Query(value = "SELECT * FROM razredi.Seznam s INNER JOIN razredi.Uporabnik u  ON s.uporabnik=uporabnik.id HAVING  ime_seznama='% seznam%' ", nativeQuery = true)
    List<Seznam> seznami(String naziv);


}
