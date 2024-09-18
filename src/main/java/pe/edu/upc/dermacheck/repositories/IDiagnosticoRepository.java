package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dermacheck.entities.Diagnostico;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IDiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {

    @Query("SELECT d.usuario, COUNT(d) FROM Diagnostico d GROUP BY d.usuario ORDER BY COUNT(d) DESC")
    List<Object[]> listarUsuariosPorDiagnosticos();

    @Query(value = "SELECT d.hora_diagnostico, d.id_diagnostico, d.id_enfermedad, d.fecha_diagnostico, d.imagen_diagnostico, d.id_usuario, u.nombres \n" +
            "FROM diagnostico d\n" +
            "JOIN usuario u ON d.id_usuario = u.id_usuario\n" +
            "WHERE d.fecha_diagnostico BETWEEN :fecha_inicio AND :fecha_final \n", nativeQuery = true)
    List<Diagnostico> listarDiagnosticosPorFecha(@Param("fecha_inicio") LocalDate fecha_inicio, @Param("fecha_final") LocalDate fecha_final);
}
