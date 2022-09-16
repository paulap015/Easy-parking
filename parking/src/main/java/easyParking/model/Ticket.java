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
@Table(name="ticket")
public class Ticket {

    @Id
    @Column(name="idTicket")
    private Integer idTicket;

    @Column(name="fecha")
    private Date fecha;

    @Column(name="total")
    private Double total;

    @OneToOne
    @JoinColumn (name="parqueo")
    private VehiculoZona parqueo;

}
