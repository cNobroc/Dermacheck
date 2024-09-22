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

    @Query(value = "SELECT d.id_diagnostico, d.fecha_diagnostico, d.hora_diagnostico, d.id_usuario\n" +
            "FROM diagnostico d\n" +
            "JOIN diagnosticox_tratamiento dt ON d.id_diagnostico = dt.id_diagnostico\n" +
            "JOIN tratamiento t ON dt.id_tratamiento = t.id_tratamiento\n" +
            "WHERE t.estado = true", nativeQuery = true)
    public List<String[]> estadodeDiagnosticoTratimientoTRUE();

    @Query(value = "SELECT d.id_diagnostico, d.fecha_diagnostico, d.hora_diagnostico, d.id_usuario\n" +
            "FROM diagnostico d\n" +
            "JOIN diagnosticox_tratamiento dt ON d.id_diagnostico = dt.id_diagnostico\n" +
            "JOIN tratamiento t ON dt.id_tratamiento = t.id_tratamiento\n" +
            "WHERE t.estado = false", nativeQuery = true)
    public List<String[]> estadodeDiagnosticoTratimientoFALSE();
}
