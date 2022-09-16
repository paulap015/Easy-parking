package easyParking.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @Column(name="cedula")
    private String cedula;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name="rol")
    private Rol rol;

    @Column(name="password")
    private String password;

}
