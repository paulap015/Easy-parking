package easyParking.service;

import easyParking.dto.TicketDTO;
import easyParking.dto.VehiculoZonaDTO;
import easyParking.model.Ticket;
import easyParking.model.Vehiculo;
import easyParking.model.VehiculoZona;

import java.util.List;

public interface IVehiculoZonaService {

    //todos los vehiculos parqueados en  una zona
    public List<VehiculoZona> vehiculesInZona(int idZona);

    //carro entrando a parquear  una zona
    public VehiculoZonaDTO save (VehiculoZonaDTO vzDTO );

    public void update (VehiculoZona vz);
    public VehiculoZona findByPlacaAndHoraFinIsNull(String placa);

    public TicketDTO generarTicket(VehiculoZona vz);
}
