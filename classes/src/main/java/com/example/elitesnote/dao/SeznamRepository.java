package com.example.elitesnote.dao;
import com.example.elitesnote.razredi.Seznam;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeznamRepository extends CrudRepository<Seznam, Long> {

    // Sprint 1; izpis enega zapisa
    @Query("SELECT s FROM Seznam s, Vsebina v WHERE v.seznam = s and v.zanr = ?1")
    List<Seznam> vrniPoZanru(String zanr);

    // Sprint 2; poizvedba z 2 modeloma
    @Query(value = "SELECT s.* FROM Seznam s INNER JOIN Uporabnik u ON s.uporabnik = u.id WHERE uporabnisko_ime = ?1", nativeQuery = true)
    List<Seznam> seznamiOdUporabnika(String ime);

    // Sprint 3; poizvedba s 3 modeli
    @Query(value = "SELECT uporabnisko_ime, ime_seznama, naslov FROM Seznam s " +
            "INNER JOIN Uporabnik u ON s.uporabnik = u.id INNER JOIN Vsebina v ON v.seznam_id = s.id", nativeQuery = true)
    List seznamUporabnikVsebina(String ime);

    // Sprint 3; poizvedba s 4 modeli
    @Query(value = "SELECT uporabnisko_ime, naslov, admin_ime FROM Seznam s INNER JOIN Uporabnik u ON s.uporabnik = u.id " +
            "INNER JOIN Vsebina v ON v.seznam_id = s.id INNER JOIN Administrator a ON v.administrator_id = a.id", nativeQuery = true)
    List uporabnikVsebinaAdmin(String ime);

    // 2 sprint
    @Query(value = "SELECT * FROM Seznam s INNER JOIN Uporabnik u ON s.uporabnik=u.id HAVING  s.ime_seznama='anime'", nativeQuery = true)
     List<Seznam> seznami(long id);
}
