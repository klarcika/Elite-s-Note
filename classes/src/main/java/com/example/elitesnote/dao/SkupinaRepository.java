package com.example.elitesnote.dao;
import com.example.elitesnote.razredi.Uporabnik;
import com.example.elitesnote.razredi.Skupina;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkupinaRepository extends CrudRepository<Skupina, Long> {
    @Query("SELECT s FROM Skupina s")
    List<Skupina> vrniSkupine();

    @Query("select s from Skupina s where s.id=?1") //vrne skupino ki ima določen id
    List<Skupina> vrniSkupino(Long id);


    @Query("select s from Skupina s where s.naziv = ?1 and s.stUporabnikov > 3 ")
    List<Skupina> vrniDolocenoSkupino(String naziv, int stUporabnikov);


  //  @Query(value="SELECT * FROM Skupina s WHERE s.naziv=:naziv AND s.stUporabnikov=3 ", nativeQuery=true)
   // List<Skupina> vrniDolocenoSkupino(String naziv, int stUporabnikov);
 //   @Query(value = "SELECT * FROM Skupina s INNER JOIN taksi_sluzba ts ON t.sluzba_id=ts.id HAVING naziv=:naziv", nativeQuery = true)
   // List<Taksi> vrniTaksijeOdSluzbe(String naziv);

}