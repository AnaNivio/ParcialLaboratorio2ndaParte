package edu.utn.testing.service;

import edu.utn.testing.model.Publicacion;
import edu.utn.testing.model.Usuario;
import edu.utn.testing.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void altaUsuarios(Usuario usuario) {

        try {
            usuarioRepository.save(usuario);

        } catch (DataIntegrityViolationException e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Sucedio un error al crear al usuario"));
        }

    }

    public void modificarUsuarios(Usuario usuario) {
        usuarioRepository.findById(usuario.getIdUsuario()).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No existe el usuario con el id: %s",usuario.getIdUsuario())));

        usuarioRepository.save(usuario);

    }
    public List<Usuario> listarUsuarios() {

        List<Usuario> usuarios = usuarioRepository.findAll();

        if (usuarios.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT, String.format("No hay usuarios cargados aun"));
        }
        return usuarios;
    }

    public List<Publicacion> listarPublicacionesUsuario(Integer idUsuario) {

        Usuario usuario= usuarioRepository.findById(idUsuario).orElseThrow(()->
                new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("El usuario no existe")));

        List<Publicacion> publicacionesUsuarios=usuario.getPublicaciones();

        if(publicacionesUsuarios.isEmpty()){
            throw  new HttpClientErrorException(HttpStatus.NO_CONTENT,String.format("El usuario aun no hizo ninguna publicacion"));
        }

        return publicacionesUsuarios;

    }

    public Usuario listarUsuarioPorId(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No existe el usuario con el id: %s",idUsuario)));

    }
}
