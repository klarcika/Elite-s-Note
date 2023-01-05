package com.example.elitesnote.dao;

import com.example.elitesnote.razredi.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VsebinaRepository extends CrudRepository<Vsebina, Long> {
    @Query("SELECT v FROM Vsebina v WHERE v.zanr = ?1 and v.naslov = ?2")
    List<Vsebina> vsebinePoZanru(String zanr, String naslov);

    @Query("SELECT v FROM Vsebina v, Administrator a WHERE v.administrator = a")
    List<Vsebina> seznamVsebine(String naslov);

    @Query("SELECT v FROM Vsebina v WHERE v.id = ?1 and v.naslov = ?2 and v.zanr = ?3")
    Vsebina vsebinaNaslovZanr(Long id, String naslov, String zanr);

    // 2 sprint
    @Query(value = "SELECT * FROM razredi.Vsebina v INNER JOIN razredi.Administrator a  ON v.administrator_id=administrator.id HAVING  naslov ='%a%' ", nativeQuery = true)
    List<Vsebina> vsebina(String naslov);
}
