package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.DiagnosticoDTO;
import pe.edu.upc.dermacheck.dtos.RolDTO;
import pe.edu.upc.dermacheck.dtos.UsuarioDTO;
import pe.edu.upc.dermacheck.dtos.UsuarioDiagnosticoDTO;
import pe.edu.upc.dermacheck.entities.Diagnostico;
import pe.edu.upc.dermacheck.entities.Rol;
import pe.edu.upc.dermacheck.serviceinterfaces.IDiagnosticoService;
import pe.edu.upc.dermacheck.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnostico")
@PreAuthorize("hasAuthority('ADMIN')")

public class DiagnosticoController {
    @Autowired
    private IDiagnosticoService diagnosticoService;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/listar-por-usuario")
    public List<UsuarioDiagnosticoDTO> listarUsuariosPorDiagnosticos() {
        return usuarioService.listarUsuariosPorDiagnosticos();
    }

    @PostMapping
    public void registrar (@RequestBody DiagnosticoDTO dto) {
        ModelMapper m = new ModelMapper();
        Diagnostico diagnostico = m.map(dto, Diagnostico.class);
        diagnosticoService.insert(diagnostico);
    }

    @GetMapping
    public List<DiagnosticoDTO> listar() {
        return diagnosticoService.list().stream().map(diagnostico -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(diagnostico, DiagnosticoDTO.class);
        }).collect(Collectors.toList());
    }

    @PatchMapping
    public void modificar(@RequestBody DiagnosticoDTO dto){
        ModelMapper m=new ModelMapper();
        Diagnostico d=m.map(dto,Diagnostico.class);
        diagnosticoService.update(d);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        diagnosticoService.delete(id);
    }
}


