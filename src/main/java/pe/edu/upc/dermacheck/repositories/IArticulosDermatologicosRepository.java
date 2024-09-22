package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dermacheck.entities.ArticulosDermatologicos;

import java.util.List;

@Repository
public interface IArticulosDermatologicosRepository extends JpaRepository<ArticulosDermatologicos, Integer> {
    @Query(" Select aD From ArticulosDermatologicos aD where aD.nombreRevista like %:nombre%")
    public List<ArticulosDermatologicos> buscar(@Param("nombre")String nombre);
}

