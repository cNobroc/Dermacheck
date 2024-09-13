package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dermacheck.entities.Anuncio;

import java.util.List;

@Repository
public interface IAnuncioRepository extends JpaRepository <Anuncio, Integer> {

    @Query("SELECT u.nombres, COUNT(a) FROM Anuncio a JOIN Usuario u ON a.idUsuario = u.idUsuario GROUP BY u.nombres")
    List<Object[]> countAnunciosByUsuario();
}
