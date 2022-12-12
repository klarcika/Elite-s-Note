package com.example.elitesnote.dao;

import com.example.elitesnote.razredi.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long> {
}
