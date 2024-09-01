package pe.edu.upc.dermacheck.serviceimplements;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.dermacheck.dtos.UsuarioDTO;
import pe.edu.upc.dermacheck.dtos.UsuarioDiagnosticoDTO;
import pe.edu.upc.dermacheck.entities.Usuario;
import pe.edu.upc.dermacheck.repositories.IDiagnosticoRepository;
import pe.edu.upc.dermacheck.repositories.IUsuarioRepository;
import pe.edu.upc.dermacheck.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<UsuarioDiagnosticoDTO> listarUsuariosPorDiagnosticos() {
        return diagnosticoRepository.listarUsuariosPorDiagnosticos().stream()
                .map(result -> {
                    Usuario usuario = (Usuario) result[0];
                    Long cantidadDiagnosticos = (Long) result[1];
                    ModelMapper modelMapper = new ModelMapper();
                    UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
                    return new UsuarioDiagnosticoDTO(usuarioDTO, cantidadDiagnosticos);
                })
                .collect(Collectors.toList());
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

}
