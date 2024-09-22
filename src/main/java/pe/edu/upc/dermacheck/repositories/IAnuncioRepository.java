package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dermacheck.entities.Anuncio;

import java.util.List;

@Repository
public interface IAnuncioRepository extends JpaRepository <Anuncio, Integer> {

    @Query(value = "SELECT u.nombres, COUNT(a)\n" +
            " FROM Anuncio a JOIN Usuario u \n" +
            " ON u.id_usuario = u.id_usuario \n" +
            " GROUP BY u.nombres", nativeQuery = true)
    public List<String[]> AnunciosXUsuario();

    @Query(value = "SELECT u.nombres, SUM(a.ingresos_por_anuncio_soles) AS total_ingresos\n" +
            "FROM usuario u\n" +
            "JOIN anuncio a ON u.id_usuario = a.user_id\n" +
            "GROUP BY u.nombres;", nativeQuery = true)
    public List<String[]> IngresosPorAnuncio();

}
