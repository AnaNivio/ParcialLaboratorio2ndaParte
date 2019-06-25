package edu.utn.testing.service;

import edu.utn.testing.model.Comentario;
import edu.utn.testing.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    public void altaComentario(Comentario comentario) {

        try {
            comentarioRepository.save(comentario);

        } catch (DataIntegrityViolationException e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Sucedio un error al crear el comentario"));
        }

    }

    public void eliminarComentario(@PathVariable("idComentario") Integer idComentario) {
        Comentario comentarioEncontrado= comentarioRepository.findById(idComentario).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No existe el comntario con el id: %s",idComentario)));

        comentarioRepository.delete(comentarioEncontrado);

    }

    @Scheduled(cron = "*/5 * * * *")
    public void deleteComentarioInX(){
        comentarioRepository.deleteComentariosInFiveMinutes();
    }

}
