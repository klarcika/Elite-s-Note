package com.example.elitesnote.dao;

import com.example.elitesnote.razredi.Administrator;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
 /*@Query("select v from Vsebina v where v.naslov = 1?")
 Vsebina vrniVsebino(String naslov);

  */
}
