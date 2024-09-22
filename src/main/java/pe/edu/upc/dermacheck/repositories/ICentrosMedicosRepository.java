package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dermacheck.entities.CentrosMedicos;

import java.util.List;

@Repository
public interface ICentrosMedicosRepository extends JpaRepository<CentrosMedicos, Integer> {
    @Query(value = "SELECT cm.nombre \n" +
            "FROM centros_medicos cm \n" +
            "JOIN diagnostico d ON cm.id_centro_medico = d.id_centro_medico \n" +
            "GROUP BY cm.nombre \n" +
            "HAVING COUNT(d.id_diagnostico) > :cantidad", nativeQuery = true)
    List<String> obtenerCentrosCantidadDiagnosticos(@Param("cantidad") int cantidad);

}
