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
            " ON a.id_usuario = u.id_usuario \n" +
            " GROUP BY u.nombres", nativeQuery = true)
    public List<String[]> AnunciosXUsuario();

}
