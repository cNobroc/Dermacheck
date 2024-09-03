package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dermacheck.entities.Anuncio;

@Repository
public interface IAnuncioRepository extends JpaRepository <Anuncio, Integer> {


}
