package pe.edu.upc.dermacheck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.dermacheck.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findOneByUsername(String username);
    List<Usuario> findByEsPremiumTrue();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Rol (nombreRol, idUsuario) VALUES (:nombreRol, :idUsuario)", nativeQuery = true)
    public void insertarRol(@Param("nombreRol") String nombreRol, @Param("idUsuario") int idUsuario);
}
