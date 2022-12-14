package easyParking.service;

import easyParking.dao.VehiculoRepository;
import easyParking.model.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplVehiculoService implements IVehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;


    @Override
    public List<Vehiculo> vehiculosUsuario(String idUsuario) {
        return vehiculoRepository.fidnByUsuario(idUsuario) ;
    }

    @Override
    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Optional<Vehiculo> findByPlaca(String placa) {
        return vehiculoRepository.findByPlaca(placa);
    }
}
