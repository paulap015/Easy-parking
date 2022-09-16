package easyParking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="vehiculozona")
public class VehiculoZona {

    @Id
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="zona")
    private Zona zona;

    @ManyToOne
    @JoinColumn(name="placa")
    private Vehiculo vehiculo;

    @Column (name="horaInicio")
    private Date horaInicio;

    @Column (name="horaFin")
    private Date horaFin;
}
