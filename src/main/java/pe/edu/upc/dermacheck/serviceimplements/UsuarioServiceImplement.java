package pe.edu.upc.dermacheck.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.dermacheck.entities.Usuario;
import pe.edu.upc.dermacheck.repositories.IDiagnosticoRepository;
import pe.edu.upc.dermacheck.repositories.IUsuarioRepository;
import pe.edu.upc.dermacheck.serviceinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuariosPremium() {
        return usuarioRepository.findByEsPremiumTrue();
    }

    @Override
    public void insert(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Autowired
    private IDiagnosticoRepository diagnosticoRepository;

    @Override
    public List<Usuario> list() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<String[]> CantidadDiagnosticosPorUsuario() {
        return usuarioRepository.DiagnosticosXUsuario();
    }

    @Override
    public List<String[]> CantidadEnfermedadesPorUsuario() {
        return usuarioRepository.EnfermedadesXUsuario();
    }

    @Override
    public List<String[]> CantidadCreditosPorUsuario() {
        return usuarioRepository.AnunciosCreditosXUsuario();
    }

    @Override
    public Usuario listId(int id) {
        return usuarioRepository.findById(id).orElse(new Usuario());
    }

    public void update(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(int id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findOneByUsername(String username) {
        return usuarioRepository.findOneByUsername(username);
    }


}
