package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.DiagnosticoDTO;
import pe.edu.upc.dermacheck.entities.Diagnostico;
import pe.edu.upc.dermacheck.serviceinterfaces.IDiagnosticoService;
import pe.edu.upc.dermacheck.serviceinterfaces.IUsuarioService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnosticos")
@PreAuthorize("hasAuthority('ADMIN')")

public class DiagnosticoController {
    @Autowired
    private IDiagnosticoService diagnosticoService;

    @Autowired
    private IUsuarioService usuarioService;

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

    @GetMapping("/fecha")
    public List<Diagnostico> diagnosticosPorFecha(@RequestParam("fechaInicio") LocalDate fechaInicio, @RequestParam("fechaFin") LocalDate fechaFin) {
        return diagnosticoService.buscarPorFecha(fechaInicio, fechaFin);
    }

    @GetMapping("/maxima-puntuacion")
    public List<Diagnostico> diagnosticosConMaximaPuntuacion() {
        return diagnosticoService.listarDiagnosticosConPuntuacionMaximaPorUsuario();
    }
}


