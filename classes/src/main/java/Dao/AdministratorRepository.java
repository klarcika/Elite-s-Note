package Dao;

import com.example.elitesnote.razredi.Administrator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
    @Query("select a from Administrator a") //zahtevnejsa poizvedba
    List<Administrator> vrniImenaAdminov(String andminIme);
}