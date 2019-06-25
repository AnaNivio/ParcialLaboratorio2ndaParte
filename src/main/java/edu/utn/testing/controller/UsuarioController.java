package edu.utn.testing.controller;


import edu.utn.testing.model.Publicacion;
import edu.utn.testing.model.Usuario;
import edu.utn.testing.repository.UsuarioRepository;
import edu.utn.testing.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void altaUsuarios(@RequestBody @Valid Usuario usuario, @RequestHeader("User-Agent") String userAgent) {
            usuario.setBrowser(userAgent);
            usuarioService.altaUsuarios(usuario);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/usuarioNuevo")
    public void modificarUsuarios(@RequestBody Usuario usuario) {
        usuarioService.modificarUsuarios(usuario);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Usuario> listarUsuarios() {

        return usuarioService.listarUsuarios();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/publicaciones/{id}")
    public List<Publicacion> listarPublicacionesUsuario(@Param("idUsuario") Integer idUsuario) {
         return usuarioService.listarPublicacionesUsuario(idUsuario);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{idUsuario}")
    public Usuario listarUsuarioPorId(@PathVariable ("idUsuario") Integer idUsuario) {
        return usuarioService.listarUsuarioPorId(idUsuario);

    }

}
