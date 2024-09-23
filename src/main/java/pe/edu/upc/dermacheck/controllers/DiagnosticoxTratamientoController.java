package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.DiagnosticoxTratamientoDTO;
import pe.edu.upc.dermacheck.dtos.EstadoDiagnosticoFalseDTO;
import pe.edu.upc.dermacheck.dtos.EstadoDiagnosticoTrueDTO;
import pe.edu.upc.dermacheck.dtos.MaterialesMedicinalesxUsuarioDTO;
import pe.edu.upc.dermacheck.entities.DiagnosticoxTratamiento;
import pe.edu.upc.dermacheck.serviceinterfaces.IDiagnosticoxTratamientoService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnosticos-tratamientos")
@PreAuthorize("hasAnyAuthority('ADMIN')")

public class DiagnosticoxTratamientoController {

    @Autowired
    private IDiagnosticoxTratamientoService diagnosticoxTratamientoService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void registrar(@RequestBody DiagnosticoxTratamientoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        DiagnosticoxTratamiento diagnosticoxTratamiento = modelMapper.map(dto, DiagnosticoxTratamiento.class);
        diagnosticoxTratamientoService.insert(diagnosticoxTratamiento);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Usuario','Especialista','ADMIN')")
    public List<DiagnosticoxTratamientoDTO> listar() {
        return diagnosticoxTratamientoService.list().stream().map(diagnosticoxTratamiento -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(diagnosticoxTratamiento, DiagnosticoxTratamientoDTO.class);
        }).collect(Collectors.toList());
    }

    @PatchMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void modificar(@RequestBody DiagnosticoxTratamientoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        DiagnosticoxTratamiento diagnosticoxTratamiento = modelMapper.map(dto, DiagnosticoxTratamiento.class);
        diagnosticoxTratamientoService.update(diagnosticoxTratamiento);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id) {
        diagnosticoxTratamientoService.delete(id);
    }

    @GetMapping("/MaterialesMedicinalesxUsuario")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<MaterialesMedicinalesxUsuarioDTO> MaterialesMedicinalesxUsuario() {
        List<String[]>lista=diagnosticoxTratamientoService.MaterialesMedicinalesxUsuario();
        List<MaterialesMedicinalesxUsuarioDTO>listaDTO=new ArrayList<>();
        for(String[]columna:lista){
            MaterialesMedicinalesxUsuarioDTO dto=new MaterialesMedicinalesxUsuarioDTO();
            dto.setNombres(columna[0]);
            dto.setIdDiagnostico(Integer.parseInt(columna[1]));
            dto.setMaterialMedicinal(columna[2]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/EstadodeTratamientoIndicandoDiagnisticoyUsuarioTERMINADO")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<EstadoDiagnosticoTrueDTO> EstadodeTratamientoIndicandoDiagnisticoyUsuarioTERMINADO() {
        List<String[]>lista=diagnosticoxTratamientoService.EstadodeDiagnosticoTratimientoTRUE();
        List<EstadoDiagnosticoTrueDTO>listaDTO=new ArrayList<>();
        for(String[]columna:lista){
            EstadoDiagnosticoTrueDTO dto=new EstadoDiagnosticoTrueDTO();
            dto.setIdDiagnostico(Integer.parseInt(columna[0]));
            dto.setFechaDiagnostico(LocalDate.parse(columna[1]));
            dto.setHoraDiagnostico(LocalTime.parse(columna[2]));
            dto.setIdUsuario(Integer.parseInt(columna[3]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/EstadodeTratamientoIndicandoDiagnisticoyUsuarioNOTERMINADO")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<EstadoDiagnosticoFalseDTO> EstadodeTratamientoIndicandoDiagnisticoyUsuarioNOTERMINADO() {
        List<String[]>lista=diagnosticoxTratamientoService.EstadodeDiagnosticoTratimientoFALSE();
        List<EstadoDiagnosticoFalseDTO>listaDTO=new ArrayList<>();
        for(String[]columna:lista){
            EstadoDiagnosticoFalseDTO dto=new EstadoDiagnosticoFalseDTO();
            dto.setIdDiagnostico(Integer.parseInt(columna[0]));
            dto.setFechaDiagnostico(LocalDate.parse(columna[1]));
            dto.setHoraDiagnostico(LocalTime.parse(columna[2]));
            dto.setIdUsuario(Integer.parseInt(columna[3]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}
