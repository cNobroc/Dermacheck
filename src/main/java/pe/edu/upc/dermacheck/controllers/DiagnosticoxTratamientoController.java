package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.DiagnosticoxTratamientoDTO;
import pe.edu.upc.dermacheck.entities.DiagnosticoxTratamiento;
import pe.edu.upc.dermacheck.serviceinterfaces.IDiagnosticoxTratamientoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnostico-tratamiento")
@PreAuthorize("hasAuthority('ADMIN')")

public class DiagnosticoxTratamientoController {

    @Autowired
    private IDiagnosticoxTratamientoService diagnosticoxTratamientoService;

    @PostMapping
    public void registrar(@RequestBody DiagnosticoxTratamientoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        DiagnosticoxTratamiento diagnosticoxTratamiento = modelMapper.map(dto, DiagnosticoxTratamiento.class);
        diagnosticoxTratamientoService.insert(diagnosticoxTratamiento);
    }

    @GetMapping
    public List<DiagnosticoxTratamientoDTO> listar() {
        return diagnosticoxTratamientoService.list().stream().map(diagnosticoxTratamiento -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(diagnosticoxTratamiento, DiagnosticoxTratamientoDTO.class);
        }).collect(Collectors.toList());
    }

    @PatchMapping
    public void modificar(@RequestBody DiagnosticoxTratamientoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        DiagnosticoxTratamiento diagnosticoxTratamiento = modelMapper.map(dto, DiagnosticoxTratamiento.class);
        diagnosticoxTratamientoService.update(diagnosticoxTratamiento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        diagnosticoxTratamientoService.delete(id);
    }
}
