package com.example.elitesnote.dao;

import com.example.elitesnote.razredi.Seznam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeznamRepository extends CrudRepository<Seznam, Long> {

    @Query("select s from Seznam s, Vsebina v where v.seznam = s and v.zanr = ?1")
    List<Seznam> vrniPoZanru(String zanr);
}
