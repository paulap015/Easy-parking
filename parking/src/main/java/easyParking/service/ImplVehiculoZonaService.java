package easyParking.service;

import easyParking.dao.TicketRepository;
import easyParking.dao.VehiculoZonaRepository;
import easyParking.dto.TicketDTO;
import easyParking.dto.VehiculoZonaDTO;
import easyParking.model.*;
import easyParking.utils.TimeUtil;
import easyParking.utils.classToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ImplVehiculoZonaService implements IVehiculoZonaService {

    @Autowired
    private VehiculoZonaRepository vzRepository;

    @Autowired
    private IZonaService zonaService;
    @Autowired
    private IVehiculoService vehiculoService;

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private classToDTO toDTO;

    @Autowired
    private TimeUtil utilTime;
    @Override
    public List<VehiculoZona> vehiculesInZona(int idZona) {
        return vzRepository.findByZona(idZona);
    }

    @Override
    public VehiculoZonaDTO save(VehiculoZonaDTO vzDTO) {
        VehiculoZonaDTO dto=new VehiculoZonaDTO();
        // para parquear verificar la zona y vehiculo existen

        Optional<Zona> zona = zonaService.findById(vzDTO.getZona());
        Optional<Vehiculo> vehiculo = vehiculoService.findByPlaca(vzDTO.getVehiculo());
        if(zona.isEmpty() || vehiculo.isEmpty()){
            dto.setMensaje("La zona o vehiculo no existen");
            return dto;
        }

        // la zona tiene espacios ?
        if(zona.get().getEspaciosLibres()<=0){
            dto.setMensaje("La zona no tiene espacio");
            return dto;
        }
        // el vehiculo ya se encuentra parqueado no debe dejar parquearlo

        System.out.println("cuantos vehiculos hay "+vzRepository.countByVehiculoAndHoraFinIsNull(vehiculo.get()) );
        if(vzRepository.countByVehiculoAndHoraFinIsNull(vehiculo.get()) >0){
        //if(vzRepository.findByVehiculo(vzDTO.getVehiculo()) != null){
            dto.setMensaje("El vehiculo ya esta parqueado");
            return dto;
        }
        // tiene espacio disminuir contador de espacios libres de zona
        zona.get().setEspaciosLibres(zona.get().getEspaciosLibres() - 1);
        zonaService.update(zona.get());
        VehiculoZona vz = new VehiculoZona();
        vz.setVehiculo(vehiculo.get());
        vz.setZona(zona.get());
        vz.setHoraInicio(new Date());
        vz.setHoraFin(null);


        return toDTO.vehiculoZonatoDTO(vzRepository.save(vz));
    }

    @Override
    public void update(VehiculoZona vz) {

        vzRepository.save(vz);
    }

    @Override
    public VehiculoZona findByPlacaAndHoraFinIsNull(String placa) {
        Optional<Vehiculo> vehiculo = vehiculoService.findByPlaca(placa);

        if(vehiculo.isEmpty()){
            return null;
        }
        VehiculoZona dto= vzRepository.findByVehiculoAndHoraFinIsNull(vehiculo.get());
        if(dto == null){
            return null;
        }


        return dto;
    }

    @Override
    public TicketDTO generarTicket(VehiculoZona vz) {
        // setear hora fin a vehiculoZona y update
        vz.setHoraFin(new Date());
        update(vz);

        //aumentar espacio libre
        Zona zona = vz.getZona();
        zona.setEspaciosLibres(zona.getEspaciosLibres() + 1);
        zonaService.update(zona);

        Tarifa tarifa = vz.getZona().getTarifa();
        long tiempoEnMinutos = utilTime.printDifference(vz.getHoraInicio(),vz.getHoraFin());

        System.out.println("Tiempo en minutos "+ tiempoEnMinutos);
        // crear ticket y asignar valores retornar factura
        Ticket ticket = new Ticket();
        ticket.setFecha(new Date());
        ticket.setTotal(tiempoEnMinutos* (tarifa.getPrecio()/60));
        ticket.setParqueo(vz);


        return toDTO.ticketToDTO(ticketRepository.save(ticket));
    }


}
