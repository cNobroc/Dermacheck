package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.dermacheck.entities.DiagnosticoxTratamiento;

import java.util.List;

public interface IDiagnosticoxTratamientoRepository extends JpaRepository<DiagnosticoxTratamiento, Integer> {

    @Query(value = "SELECT u.nombres,d.id_diagnostico, t.material_medicinal \n" +
            " FROM Diagnostico d\n" +
            " JOIN Usuario u ON d.id_usuario = u.id_usuario\n" +
            " JOIN diagnosticox_tratamiento dt ON d.id_diagnostico = dt.id_diagnostico\n" +
            " JOIN Tratamiento t ON dt.id_tratamiento = t.id_tratamiento", nativeQuery = true)
    public List<String[]> listarMaterialesMedicinalesPorUsuario();
}
