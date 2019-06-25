package edu.utn.testing.repository;

import edu.utn.testing.model.URProyectionClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface URPClaseRepository extends JpaRepository<URProyectionClase,Integer> {

    @Query(value = "SELECT p.titulo,u.nombre,count(c.idComentario) as CantidadComentarios FROM Publicacion p INNER JOIN Usuario u LEFT JOIN Comnetario c ",nativeQuery = true)
    URProyectionClase getProyectionByClass();

}
