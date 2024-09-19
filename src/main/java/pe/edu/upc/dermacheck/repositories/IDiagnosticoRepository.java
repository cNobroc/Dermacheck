package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dermacheck.entities.Diagnostico;

import java.util.List;

@Repository
public interface IDiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {

}
