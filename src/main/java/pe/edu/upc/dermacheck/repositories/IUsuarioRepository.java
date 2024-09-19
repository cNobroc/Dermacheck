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

    @Query(value = "SELECT u.nombres, COUNT(d.id_diagnostico)\n" +
            " FROM Diagnostico d JOIN Usuario u \n" +
            " ON d.id_usuario = u.id_usuario\n" +
            " GROUP BY u.nombres", nativeQuery = true)
    public List<String[]> DiagnosticosXUsuario();

}
