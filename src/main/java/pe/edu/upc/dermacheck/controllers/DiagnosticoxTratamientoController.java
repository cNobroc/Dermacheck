package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.DiagnosticoxTratamientoDTO;
import pe.edu.upc.dermacheck.entities.DiagnosticoxTratamiento;
import pe.edu.upc.dermacheck.serviceinterfaces.IDiagnosticoxTratamientoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnostico-tratamiento")
public class DiagnosticoxTratamientoController {
    @Autowired
    private IDiagnosticoxTratamientoService diagnosticoxTratamientoService;

    @PostMapping
    public void registrar(@RequestBody DiagnosticoxTratamientoDTO dto) {
        ModelMapper m = new ModelMapper();
        DiagnosticoxTratamiento d = m.map(dto, DiagnosticoxTratamiento.class);
        diagnosticoxTratamientoService.insert(d);
    }

    @GetMapping
    public List<DiagnosticoxTratamientoDTO> listar() {
        return diagnosticoxTratamientoService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DiagnosticoxTratamientoDTO.class);
        }).collect(Collectors.toList());
    }

    @PatchMapping
    public void modificar(@RequestBody DiagnosticoxTratamientoDTO dto) {
        ModelMapper m = new ModelMapper();
        DiagnosticoxTratamiento d = m.map(dto, DiagnosticoxTratamiento.class);
        diagnosticoxTratamientoService.update(d);
    }

    @DeleteMapping("/{idDiagnostico}/{idTratamiento}")
    public void eliminar(@PathVariable("idDiagnostico") int idDiagnostico,
                         @PathVariable("idTratamiento") int idTratamiento) {
        diagnosticoxTratamientoService.delete(idDiagnostico, idTratamiento);
    }
}
