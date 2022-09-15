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
@Table(name="vehiculo")
public class Vehiculo {

    @Id
    @Column(name="placa")
    private String placa;

    @Column(name="tipoVehiculo")
    private String tipoVehiculo;

    @ManyToOne
    @JoinColumn(name="usuario", nullable=false)
    private Usuario usuario;
}
