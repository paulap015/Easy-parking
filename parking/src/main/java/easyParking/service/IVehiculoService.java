package easyParking.service;

import easyParking.model.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface IVehiculoService {

    public List<Vehiculo> vehiculosUsuario(String idUsuario);

    public List<Vehiculo> findAll();

    public Optional<Vehiculo> findByPlaca(String placa);
}
