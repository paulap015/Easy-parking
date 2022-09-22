package easyParking.utils;

import easyParking.dto.TicketDTO;
import easyParking.dto.VehiculoZonaDTO;
import easyParking.model.Ticket;
import easyParking.model.VehiculoZona;
import org.springframework.stereotype.Component;

@Component
public class classToDTO {
    public classToDTO() {

    }

    public VehiculoZonaDTO vehiculoZonatoDTO(VehiculoZona vz){
        VehiculoZonaDTO dto = new VehiculoZonaDTO();
        dto.setId(vz.getId());
        dto.setVehiculo(vz.getVehiculo().getPlaca());
        dto.setZona(vz.getZona().getIdZona());
        dto.setHoraInicio(vz.getHoraInicio());
        dto.setHoraFin(vz.getHoraFin());

        return dto;
    }

    public TicketDTO ticketToDTO(Ticket ticket){
        TicketDTO dto = new TicketDTO();
        dto.setIdTicket(ticket.getIdTicket());
        dto.setFecha(ticket.getFecha());
        dto.setTotal(ticket.getTotal());
        dto.setParqueo(ticket.getParqueo().getId());

        return dto;
    }
}
