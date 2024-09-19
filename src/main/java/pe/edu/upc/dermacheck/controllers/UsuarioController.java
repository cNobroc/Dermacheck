package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.*;
import pe.edu.upc.dermacheck.entities.Usuario;
import pe.edu.upc.dermacheck.serviceinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
@PreAuthorize("hasAuthority('ADMIN')")

public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/premium")
    public List<UsuarioDTO> listarUsuariosPremium() {
        return usuarioService.listarUsuariosPremium().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar (@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper m = new ModelMapper();
        Usuario user = m.map(usuarioDTO, Usuario.class);
        usuarioService.insert(user);
    }

    @GetMapping("/{id}") // Agregar un get mapping porque estamos recuperando un registro por id cambiante (VARÍA)
    public UsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(usuarioService.listId(id), UsuarioDTO.class);
        return dto;
    }

    @PatchMapping
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario usu = m.map(dto, Usuario.class);
        usuarioService.update(usu);
    }

    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable("id") Integer id) {
        usuarioService.delete(id);
    }

    @GetMapping("/listar-por-usuario")
    public List<DiagnosticoXUsuarioDTO> CantidadDiagnosticosPorUsuario() {
        List<String[]>lista=usuarioService.CantidadDiagnosticosPorUsuario();
        List<DiagnosticoXUsuarioDTO>listaDTO=new ArrayList<>();
        for(String[]columna:lista){
            DiagnosticoXUsuarioDTO dto=new DiagnosticoXUsuarioDTO();
            dto.setNombres(columna[0]);
            dto.setCount(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/Usuario-Cantidad-Enfermedades")
    public List<EnfermedadesxUsuarioDTO> CantidadEnfermedadesPorUsuario() {
        List<String[]>lista=usuarioService.CantidadEnfermedadesPorUsuario();
        List<EnfermedadesxUsuarioDTO>listaDTO=new ArrayList<>();
        for(String[]columna:lista){
            EnfermedadesxUsuarioDTO dto=new EnfermedadesxUsuarioDTO();
            dto.setNombreUsuario(columna[0]);
            dto.setCantidadEnfermedades(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/Usuario-Cantidad-Creditos")
    public List<UsuarioxAnuncioCreditosDTO> CantidadCreditosPorUsuario() {
        List<String[]>lista=usuarioService.CantidadCreditosPorUsuario();
        List<UsuarioxAnuncioCreditosDTO>listaDTO=new ArrayList<>();
        for(String[]columna:lista){
            UsuarioxAnuncioCreditosDTO dto=new UsuarioxAnuncioCreditosDTO();
            dto.setNombreUsuario(columna[0]);
            dto.setCantidadCreditos(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}

