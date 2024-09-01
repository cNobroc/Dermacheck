package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.dermacheck.dtos.DiagnosticoDTO;
import pe.edu.upc.dermacheck.dtos.UsuarioDTO;
import pe.edu.upc.dermacheck.dtos.UsuarioDiagnosticoDTO;
import pe.edu.upc.dermacheck.serviceinterfaces.IDiagnosticoService;
import pe.edu.upc.dermacheck.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController {
    @Autowired
    private IDiagnosticoService diagnosticoService;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/listar-por-usuario")
    public List<UsuarioDiagnosticoDTO> listarUsuariosPorDiagnosticos() {
        return usuarioService.listarUsuariosPorDiagnosticos();
    }

    @GetMapping
    public List<DiagnosticoDTO> listar() {
        return diagnosticoService.list().stream().map(diagnostico -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(diagnostico, DiagnosticoDTO.class);
        }).collect(Collectors.toList());
    }
}


