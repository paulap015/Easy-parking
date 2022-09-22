package easyParking.dao;

import easyParking.model.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZonaRepository extends JpaRepository<Zona,Integer> {
    public Zona save(Zona zona);
    public Optional<Zona> findById(Integer id);
}
