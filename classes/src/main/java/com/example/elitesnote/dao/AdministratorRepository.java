package com.example.elitesnote.dao;

import com.example.elitesnote.razredi.Administrator;
import com.example.elitesnote.razredi.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
 @Query("select id from Administrator, v Vsebina where  v.administrator_id = id and id=1?")
 List<Vsebina> vrniVsebino(String naslov);



}
