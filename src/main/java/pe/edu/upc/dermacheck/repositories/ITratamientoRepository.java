package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.dermacheck.entities.Tratamiento;

public interface ITratamientoRepository extends JpaRepository <Tratamiento, Integer> {

}
