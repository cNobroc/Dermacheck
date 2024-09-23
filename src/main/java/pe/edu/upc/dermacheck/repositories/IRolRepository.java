package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dermacheck.entities.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {

}
