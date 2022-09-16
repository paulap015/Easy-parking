package easyParking.service;

import easyParking.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    public List<Vehiculo> vehiculosUsuario(String idUsuario);

    public List<Vehiculo> findAll();
}
