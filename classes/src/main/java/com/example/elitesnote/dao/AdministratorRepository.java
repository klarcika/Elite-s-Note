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

    //2. sprint
    @Query(value = "SELECT ts.id, ts.naziv, t.id, t.registrska_stevilka FROM taksi t INNER JOIN taksi_sluzba ts ON t.sluzba_id=ts.id INNER JOIN taksist tak ON tak.sluzba_id=ts.id WHERE tak.ime=:ime", nativeQuery = true)
    List vrniTaksijeInSluzbe(String ime);

}
