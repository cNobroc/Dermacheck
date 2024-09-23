package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.dermacheck.entities.Enfermedad;


public interface IEnfermedadRepository extends JpaRepository<Enfermedad, Integer> {

}
