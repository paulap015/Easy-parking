package easyParking.controller;

import easyParking.dto.TicketDTO;
import easyParking.dto.VehiculoZonaDTO;
import easyParking.model.Vehiculo;
import easyParking.model.VehiculoZona;
import easyParking.service.IVehiculoZonaService;
import easyParking.utils.classToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("vehiculozona")
public class VehiculoZonaController {

    @Autowired
    private IVehiculoZonaService vzService;

    @Autowired
    private classToDTO toDTO;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody VehiculoZonaDTO vzDTO) throws ParseException {
        VehiculoZonaDTO vz = vzService.save(vzDTO);

        if(vz.getMensaje() != null){

            return ResponseEntity.ok(vz);
        }

        vz.setMensaje("Operacion Exitosa");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(vz);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("{id}")
    public ResponseEntity<?> getVehiculesInZona(@PathVariable("id") Integer idZona){

        List<VehiculoZona> vehiculesInZona = vzService.vehiculesInZona(idZona);
        if (vehiculesInZona==null){
            return ResponseEntity.ok(VehiculoZona.builder().build());
        }
        List<VehiculoZonaDTO> vehiculos = new ArrayList<>();

        for(VehiculoZona vz : vehiculesInZona){
            vehiculos.add(toDTO.vehiculoZonatoDTO(vz));
        }
        return ResponseEntity.ok(vehiculos);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{placa}")
    public ResponseEntity<?> salirParqueadero(@PathVariable String placa) throws ParseException {
        // obtener vehiculo zona de la placa verificar que la hora fin sea null
        VehiculoZona vz = vzService.findByPlacaAndHoraFinIsNull(placa);

        if(vz == null){

            return ResponseEntity.ok(new VehiculoZonaDTO("Error no se encontro vehiculo parquedado"));
        }

        TicketDTO dto = vzService.generarTicket(vz);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
    }
}
