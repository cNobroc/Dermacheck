package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dermacheck.entities.ArticulosDermatologicos;

@Repository
public interface IArticulosDermatologicosRepository extends JpaRepository<ArticulosDermatologicos, Integer> {

}

