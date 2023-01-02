package com.example.elitesnote.dao;

import com.example.elitesnote.razredi.Administrator;
import com.example.elitesnote.razredi.Skupina;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {


    @Query("select a from Administrator a")
    List<Administrator> vrniAdmin();

    @Query("select a from Administrator a where a.adminIme= ?1  and a.geslo= ?2 ")
    List<Administrator> vrniDolocenegaAdmina(String adminIme, String geslo);

    @Query("select a from Administrator a where a.adminIme= 'admin'  and a.geslo= ?1  ")
    List<Administrator> vrniDolocenegaAdmina2(String adminIme, String geslo);

    //3. sprint
    @Query(value = "SELECT a.id, v.naslov FROM administrator a INNER JOIN Vsebina v ON a.id=vsebina.administrator.id INNER JOIN Seznam s ON vsebina.seznam_id=seznam.id WHERE s.ime_seznama='%a%'", nativeQuery = true)
    List vrniAdminaInVsebine(String ime);


}
