package edu.utn.testing.controller;

import edu.utn.testing.model.Comentario;
import edu.utn.testing.model.EntidadListas;
import edu.utn.testing.model.Publicacion;
import edu.utn.testing.model.Usuario;
import edu.utn.testing.service.ComentarioService;
import edu.utn.testing.service.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/listas")
public class EntidadListasController {
    @Autowired
    private EntidadService entidadService;

    @GetMapping("/allContent")
    public ResponseEntity<?> listarUsuarios() {
        CompletableFuture<List<Usuario>> usuarios=entidadService.listarUsuarios();
        CompletableFuture<List<Comentario>> comentarios=entidadService.listarComentarios();
        CompletableFuture<List<Publicacion>> publicaciones=entidadService.listarPublicacion();

        return ResponseEntity.status(HttpStatus.OK)
                .body("Usuarios: "+ usuarios.join() + " Comentarios: " + comentarios.join() + " Publicaciones: "+ publicaciones.join());
    }
}
