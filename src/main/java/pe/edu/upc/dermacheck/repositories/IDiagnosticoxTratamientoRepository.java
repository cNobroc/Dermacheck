package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.dermacheck.entities.DiagnosticoxTratamiento;
import pe.edu.upc.dermacheck.entities.DiagnosticoxTratamientoId;

public interface IDiagnosticoxTratamientoRepository extends JpaRepository<DiagnosticoxTratamiento, DiagnosticoxTratamientoId> {
}
