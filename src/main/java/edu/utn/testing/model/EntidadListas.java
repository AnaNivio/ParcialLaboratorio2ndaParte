package edu.utn.testing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntidadListas {

    private List<Usuario> usuarioList;
    private List<Publicacion> publicacionList;
    private List<Comentario> comentarioList;
}
