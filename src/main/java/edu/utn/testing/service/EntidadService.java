package edu.utn.testing.service;

import edu.utn.testing.model.Comentario;
import edu.utn.testing.model.Publicacion;
import edu.utn.testing.model.Usuario;
import edu.utn.testing.repository.ComentarioRepository;
import edu.utn.testing.repository.PublicacionRepository;
import edu.utn.testing.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EntidadService {
    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PublicacionRepository publicacionRepository;

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Usuario>> listarUsuarios() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(usuarioRepository.findAll());
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Comentario>> listarComentarios() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return CompletableFuture.completedFuture(comentarioRepository.findAll());
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Publicacion>> listarPublicacion() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(publicacionRepository.findAll());
    }
}
