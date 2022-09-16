package easyParking.controller;

import easyParking.service.IVehiculoService;
import easyParking.model.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("vehiculo")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}us")
    public ResponseEntity vehiculosDeUsuario(@PathVariable("id") String id){

        List<Vehiculo> vehiculos = vehiculoService.vehiculosUsuario(id);
        if(vehiculos==null){
            return ResponseEntity.ok(Vehiculo.builder().build());
        }
        return ResponseEntity.ok(vehiculos);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("")
    public ResponseEntity<?> findAll(){

        List<Vehiculo> vehiculos = vehiculoService.findAll();
        if(vehiculos==null){
            return ResponseEntity.ok(Vehiculo.builder().build());
        }
        return ResponseEntity.ok(vehiculos);
    }

}
