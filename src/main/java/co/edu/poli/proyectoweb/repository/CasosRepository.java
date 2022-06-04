package co.edu.poli.proyectoweb.repository;

import co.edu.poli.proyectoweb.model.Casos;

import co.edu.poli.proyectoweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CasosRepository extends JpaRepository<Casos, Integer> {

    @Query(value = "select * from casos left join user on casos.user_id = user.id where user.email = ?1",nativeQuery = true)
    //@Query("FROM Casos WHERE user.id = ?1")
    List<Casos> findByUserId(String UserEmail);
}
