package easyParking.service;

import easyParking.dao.ZonaRepository;
import easyParking.model.Tarifa;
import easyParking.model.Zona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImplZonaService implements IZonaService {

    @Autowired
    private ZonaRepository zonaRepository;
    @Override
    public Zona update(Zona zona) {
        return zonaRepository.save(zona);
    }

    @Override
    public Optional<Zona> findById(Integer idZona) {
        return zonaRepository.findById(idZona);
    }

    @Override
    public Tarifa findByIdTarifa(int idTarifa) {
        return null;
    }
}
