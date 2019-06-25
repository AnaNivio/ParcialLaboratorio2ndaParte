package edu.utn.testing.repository;

import edu.utn.testing.model.Comentario;
import edu.utn.testing.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {


}
