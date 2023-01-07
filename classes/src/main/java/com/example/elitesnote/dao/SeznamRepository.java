package com.example.elitesnote.dao;
import com.example.elitesnote.razredi.Seznam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeznamRepository extends CrudRepository<Seznam, Long> {

    @Query("SELECT s FROM Seznam s, Vsebina v WHERE v.seznam = s and v.zanr = ?1")
    List<Seznam> vrniPoZanru(String zanr);

    @Query("SELECT s FROM Seznam s, Uporabnik u WHERE s.uporabnik = u and u.id = ?1")
    List<Seznam> uporabnikoviSeznami(Long id);

    // 2 sprint
  //  @Query(value = "SELECT * FROM razredi.Seznam s INNER JOIN razredi.Uporabnik u  ON s.uporabnik=u.id HAVING  ime_seznama='% a %' ", nativeQuery = true)
 //   List<Seznam> seznami(String naziv);

    @Query(value = "SELECT * FROM Seznam s INNER JOIN Uporabnik u ON s.uporabnik=u.id HAVING  s.ime_seznama='anime'", nativeQuery = true)
     List<Seznam> seznami(long id);
}
