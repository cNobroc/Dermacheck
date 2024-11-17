package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.DiagnosticoXUsuarioDTO;
import pe.edu.upc.dermacheck.dtos.EnfermedadesxUsuarioDTO;
import pe.edu.upc.dermacheck.dtos.UsuarioDTO;
import pe.edu.upc.dermacheck.dtos.UsuarioxAnuncioCreditosDTO;
import pe.edu.upc.dermacheck.entities.Usuario;
import pe.edu.upc.dermacheck.serviceinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsuarioDTO> listar() {
        return usuarioService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/premium")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsuarioDTO> listarUsuariosPremium() {
        return usuarioService.listarUsuariosPremium().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper m = new ModelMapper();
        Usuario user = m.map(usuarioDTO, Usuario.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usuarioService.insert(user);
    }

    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(usuarioService.listId(id), UsuarioDTO.class);
        return dto;
    }

    @PatchMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario usu = m.map(dto, Usuario.class);
        usuarioService.update(usu);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id) {
        usuarioService.delete(id);
    }

    @GetMapping("/CantidadDiagnosticosPorUsuario")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<DiagnosticoXUsuarioDTO> CantidadDiagnosticosPorUsuario() {
        List<String[]> lista = usuarioService.CantidadDiagnosticosPorUsuario();
        List<DiagnosticoXUsuarioDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            DiagnosticoXUsuarioDTO dto = new DiagnosticoXUsuarioDTO();
            dto.setNombres(columna[0]);
            dto.setCount(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/Usuario-Cantidad-Enfermedades")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<EnfermedadesxUsuarioDTO> CantidadEnfermedadesPorUsuario() {
        List<String[]> lista = usuarioService.CantidadEnfermedadesPorUsuario();
        List<EnfermedadesxUsuarioDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            EnfermedadesxUsuarioDTO dto = new EnfermedadesxUsuarioDTO();
            dto.setNombreUsuario(columna[0]);
            dto.setCantidadEnfermedades(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/Usuario-Cantidad-Creditos")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsuarioxAnuncioCreditosDTO> CantidadCreditosPorUsuario() {
        List<String[]> lista = usuarioService.CantidadCreditosPorUsuario();
        List<UsuarioxAnuncioCreditosDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            UsuarioxAnuncioCreditosDTO dto = new UsuarioxAnuncioCreditosDTO();
            dto.setNombreUsuario(columna[0]);
            dto.setCantidadCreditos(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/exists/{username}")
    public boolean checkUsernameExists(@PathVariable String username) {
        Usuario usuario = usuarioService.findOneByUsername(username);
        return usuario != null;
    }

}
