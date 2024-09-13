package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dermacheck.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByEsPremiumTrue();

}
