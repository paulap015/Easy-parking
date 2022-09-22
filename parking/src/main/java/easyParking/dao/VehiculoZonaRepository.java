package easyParking.dao;

import easyParking.model.Vehiculo;
import easyParking.model.VehiculoZona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoZonaRepository extends JpaRepository<VehiculoZona,Integer> {

    @Query(value = "SELECT * FROM vehiculozona WHERE zona =:idZona" , nativeQuery = true)
    public List<VehiculoZona> findByZona(int idZona);

    //@Query(value = "SELECT * FROM vehiculozona WHERE placa = ':placa' and horaFin is NULL", nativeQuery = true)
    public VehiculoZona findByVehiculoAndHoraFinIsNull(Vehiculo placa);

    //@Query(value = "SELECT COUNT(*) FROM VehiculoZona  WHERE placa=':placa' and `horaFin` is Null",nativeQuery = true)
    public long countByVehiculoAndHoraFinIsNull(Vehiculo placa);
}
