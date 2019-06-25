package edu.utn.testing.controller;

import edu.utn.testing.model.Comentario;
import edu.utn.testing.repository.ComentarioRepository;
import edu.utn.testing.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void altaComentario(@RequestBody @Valid Comentario comentario) {

        comentarioService.altaComentario(comentario);

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{idComentario}")
    public void eliminarComentario(@PathVariable ("idComentario") Integer idComentario) {
        comentarioService.eliminarComentario(idComentario);

    }

    private void deleteComentarioInX(){
        comentarioService.deleteComentarioInX();
    }
}
