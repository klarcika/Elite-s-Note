package com.example.elitesnote.dao;

import com.example.elitesnote.razredi.Administrator;
import com.example.elitesnote.razredi.Seznam;
import com.example.elitesnote.razredi.Uporabnik;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeznamRepository extends CrudRepository<Seznam, Long> {

    @Query("SELECT s FROM Seznam s, Vsebina v WHERE v.seznam = s and v.zanr = ?1")
    List<Seznam> vrniPoZanru(String zanr);

    @Query("SELECT s FROM Seznam s, Uporabnik u WHERE s.uporabnik = u and u.id = ?1")
    List<Seznam> uporabnikoviSeznami(Long id);

    // 2 sprint
    @Query(value = "SELECT * FROM razredi.Seznam s INNER JOIN razredi.Uporabnik u  ON s.uporabnik=uporabnik.id HAVING  ime_seznama='% seznam%' ", nativeQuery = true)
    List<Seznam> seznami(String naziv);


}
