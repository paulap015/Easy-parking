package easyParking.dao;

import easyParking.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo,String> {

    //todos los vehiculos de un usuario
    @Query(value = "SELECT * FROM vehiculo WHERE usuario = :id" ,  nativeQuery = true) //consulta parametrizada reemplaza el id por lo que enviemos en el metodo
    public List<Vehiculo> fidnByUsuario(@Param("id")String id);

    //@Query
    public List<Vehiculo> findAll();
}
