package edu.utn.testing.repository;

import edu.utn.testing.model.Comentario;
import edu.utn.testing.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion,Integer> {
    @Query(value = "SELECT p.titulo,u.nombre,count(c.idComentario) as CantidadComentarios FROM Publicacion p INNER JOIN Usuario u LEFT JOIN Comnetario c ",nativeQuery = true)
    URProjectionInterfaz getProyectionByInterface();

}
