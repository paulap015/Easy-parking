package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="zona")
public class Zona {

    @Id
    @Column(name="idZona")
    private String idZona;

    @Column(name="nombreZona")
    private String nombreZona;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="espaciosLibres")
    private Integer espaciosLibres;

    @ManyToOne
    @JoinColumn(name="tarifa")
    private Tarifa tarifa;
}
