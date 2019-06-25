package edu.utn.testing.repository;

import edu.utn.testing.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Integer> {
    @Query("DELETE FROM Comentario WHERE MINUTE(NOW()) - MINUTE(votesDate) =5")
    void deleteComentariosInFiveMinutes();
}
