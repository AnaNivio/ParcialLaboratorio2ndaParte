package edu.utn.testing.service;

import edu.utn.testing.model.Publicacion;
import edu.utn.testing.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

@Service
public class PublicacionService {
    @Autowired
    PublicacionRepository publicacionRepository;

    public void altaPublicacion(Publicacion publicacion) {

        try {
            publicacionRepository.save(publicacion);

        } catch (DataIntegrityViolationException e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Sucedio un error al crear la publicacion"));
        }

    }
}
