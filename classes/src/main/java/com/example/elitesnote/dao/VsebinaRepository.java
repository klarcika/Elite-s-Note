package com.example.elitesnote.dao;

import com.example.elitesnote.razredi.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VsebinaRepository extends CrudRepository<Vsebina, Long> {
    @Query("select v from Vsebina v where v.zanr = ?1 and v.naslov = ?2")
    List<Vsebina> vsebinePoZanru(String zanr, String naslov);

    @Query("select v from Vsebina v, Administrator a where v.administrator = a  ")
    List<Vsebina> seznamVsebine(String naslov);
}
