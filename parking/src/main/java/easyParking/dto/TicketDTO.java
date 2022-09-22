package easyParking.dto;

import easyParking.model.VehiculoZona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketDTO {

    private Integer idTicket;
    private Date fecha;
    private Double total;
    private Integer parqueo;
}
