package com.example.elitesnote.dao;

import com.example.elitesnote.razredi.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VsebinaRepository extends CrudRepository<Vsebina, Long> {

    // Sprint 1; poizvedba z 2 parametroma
    @Query("SELECT v FROM Vsebina v WHERE v.zanr = ?1 and v.naslov = ?2")
    List<Vsebina> vsebinePoZanru(String zanr, String naslov);

    @Query("SELECT v FROM Vsebina v, Administrator a WHERE v.administrator = a")
    List<Vsebina> seznamVsebine(String naslov);

    // Projekt/Sprint 1; poizvedba s 3 parametri
    @Query("SELECT v FROM Vsebina v WHERE v.id = ?1 and v.naslov = ?2 and v.zanr = ?3")
    Vsebina vsebinaNaslovZanr(Long id, String naslov, String zanr);

    // Sprint 2; poizvedba z 2 modeloma
    @Query(value = "SELECT v.* FROM Vsebina v INNER JOIN Seznam s ON v.seznam = s.id WHERE ime_seznama = ?1", nativeQuery = true)
    List<Vsebina> vsebineIzSeznama(String ime);

    // Sprint 3; poizvedba z 3 modeloma
    @Query(value = "SELECT naslov, ime_seznama, admin_ime FROM Vsebina v " +
            "INNER JOIN Seznam s ON v.seznam = s.id INNER JOIN Administrator a ON v.administrator_id = a.id", nativeQuery = true)
    List vsebinaSeznamAdmin(String ime);

    // 2 sprint
    @Query(value = "SELECT * FROM razredi.Vsebina v INNER JOIN razredi.Administrator a  ON v.administrator_id=administrator.id HAVING  naslov ='%a%' ", nativeQuery = true)
    List<Vsebina> vsebina(String naslov);
}
