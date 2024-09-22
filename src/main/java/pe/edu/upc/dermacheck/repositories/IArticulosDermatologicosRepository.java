package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dermacheck.entities.ArticulosDermatologicos;

import java.util.List;

@Repository
public interface IArticulosDermatologicosRepository extends JpaRepository<ArticulosDermatologicos, Integer> {
    @Query(value = "SELECT u.nombres, COUNT(a)\n" +
            " FROM ArticulosDermatologicos a JOIN Usuario u \n" +
            " ON a.id_usuario = u.id_usuario \n" +
            " GROUP BY u.nombres", nativeQuery = true)
    public List<String[]> RevistasPorUsuario();

    @Query(" Select aD From ArticulosDermatologicos aD where aD.nombreRevista like %:nombre%")
    public List<ArticulosDermatologicos> buscar(@Param("nombre")String nombre);
}

