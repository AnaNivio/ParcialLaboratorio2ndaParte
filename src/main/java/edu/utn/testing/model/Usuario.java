package edu.utn.testing.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Integer idUsuario;

    @NotNull(message = "Un usuario debe tener nombre")
    private String nombre;
    @NotNull(message = "Un usuario debe tener apellido")
    private String apellido;
    private String browser;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuarioPublicacion")
    @JsonManagedReference
    private List<Publicacion> publicaciones;
}
