package com.example.elitesnote.dao;

import com.example.elitesnote.razredi.Administrator;
import com.example.elitesnote.razredi.Skupina;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
 /*@Query("select v from Vsebina v where v.naslov = 1?")
 Vsebina vrniVsebino(String naslov);

  */

    @Query("select a from Administrator a")
    List<Administrator> vrniAdmin();

    @Query("select a from Administrator a where a.adminIme= ?1  and a.geslo= ?2 ")
    List<Skupina> vrniDolocenegaAdmina(String adminIme, String geslo);

  //  @Query(value="SELECT * FROM uporabnik u WHERE u.ime=:ime AND u.geslo=:geslo ", nativeQuery=true)
}
