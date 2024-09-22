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
    @Query("SELECT d FROM Diagnostico d WHERE d.fechaDiagnostico BETWEEN :fechaInicio AND :fechaFin")
    List<Diagnostico> buscarPorFecha(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);

    @Query("SELECT d FROM Diagnostico d WHERE d.puntuacion = (" +
            "SELECT MAX(d2.puntuacion) FROM Diagnostico d2 WHERE d2.usuario.idUsuario = d.usuario.idUsuario)")
    List<Diagnostico> buscarDiagnosticosConPuntuacionMaximaPorUsuario();

    @Query("SELECT AVG(d.puntuacion) FROM Diagnostico d WHERE d.centrosMedicos.idCentroMedico = :idCentroMedico")
    Double obtenerPromedioPuntuacionPorCentroMedico(@Param("idCentroMedico") int idCentroMedico);



}
