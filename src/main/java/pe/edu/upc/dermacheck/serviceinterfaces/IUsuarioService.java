package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.dtos.UsuarioDiagnosticoDTO;
import pe.edu.upc.dermacheck.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> list();
    List<String[]> CantidadDiagnosticosPorUsuario();
    List<Usuario> listarUsuariosPremium();
    public void insert(Usuario usuario);
    public Usuario listId(int id);
    public void update(Usuario usuario);
    public void delete(int id);

}
