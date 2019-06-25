package edu.utn.testing.controller;

import edu.utn.testing.model.Publicacion;
import edu.utn.testing.repository.PublicacionRepository;
import edu.utn.testing.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;


@RestController
@RequestMapping("/publicacion")
public class PublicacionController {
    @Autowired
    private PublicacionService publicacionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void altaPublicacion(@RequestBody @Valid Publicacion publicacion) {

       publicacionService.altaPublicacion(publicacion);
    }

}
