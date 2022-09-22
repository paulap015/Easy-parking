package easyParking.dto;

import easyParking.model.Vehiculo;
import easyParking.model.Zona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VehiculoZonaDTO {

    private Integer id;
    private Integer zona;
    private String vehiculo;
    private Date horaInicio;
    private Date horaFin;
    private String mensaje;

    public VehiculoZonaDTO(String mensaje) {
        this.mensaje = mensaje;
    }
}
