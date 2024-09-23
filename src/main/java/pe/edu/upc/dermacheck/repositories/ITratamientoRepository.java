package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.dermacheck.entities.Diagnostico;
import pe.edu.upc.dermacheck.entities.Tratamiento;

import java.time.LocalDate;
import java.util.List;

public interface ITratamientoRepository extends JpaRepository <Tratamiento, Integer> {
    @Query(value = "SELECT * FROM tratamiento t WHERE t.fecha_inicio = :fechaInicio", nativeQuery = true)
    List<Tratamiento> buscarPorFechaInicio(@Param("fechaInicio") LocalDate fechaInicio);
}
