package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.dermacheck.entities.DiagnostImage;

import java.util.List;

public interface IDiagnosticImageRepository extends JpaRepository<DiagnostImage, Integer> {
    @Query("from DiagnostImage d WHERE d.diagnostico.idDiagnostico =: id")
    public List<DiagnostImage> allImageForDiagnostic(int id);
}
