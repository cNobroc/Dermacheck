package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.dermacheck.entities.Recuperacion;

import java.util.List;

public interface IRecuperacionRepository extends JpaRepository<Recuperacion, Integer> {

    @Query(value = "SELECT u.nombres, COUNT(r)\n" +
            " FROM Recuperacion r JOIN Usuario u \n" +
            " ON r.id_usuario = u.id_usuario \n" +
            " GROUP BY u.nombres", nativeQuery = true)
    public List<String[]> RecuperacionesPorUsuario();
}
