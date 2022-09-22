package easyParking.service;

import easyParking.dto.ZonaDTO;
import easyParking.model.Tarifa;
import easyParking.model.Zona;

import java.util.Optional;

public interface IZonaService {

    // crear o modificar zona
    public Zona update(Zona zona);
    public Optional<Zona> findById(Integer idZona);
    public Tarifa findByIdTarifa(int idTarifa);
}
