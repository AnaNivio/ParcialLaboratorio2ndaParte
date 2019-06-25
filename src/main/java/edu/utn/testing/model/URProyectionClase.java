package edu.utn.testing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class URProyectionClase {
    @Id
    private String titulo;
    private String nombre;
    private Integer CantidadComentarios;
}
