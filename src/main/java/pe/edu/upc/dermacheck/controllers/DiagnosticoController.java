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
@PreAuthorize("hasAnyAuthority('ADMIN')")

public class DiagnosticoController {
    @Autowired
    private IDiagnosticoService diagnosticoService;

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar (@RequestBody DiagnosticoDTO dto) {
        ModelMapper m = new ModelMapper();
        Diagnostico diagnostico = m.map(dto, Diagnostico.class);
        diagnosticoService.insert(diagnostico);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Cliente','Especialista','ADMIN')")
    public List<DiagnosticoDTO> listar() {
        return diagnosticoService.list().stream().map(diagnostico -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(diagnostico, DiagnosticoDTO.class);
        }).collect(Collectors.toList());
    }

    @PatchMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void modificar(@RequestBody DiagnosticoDTO dto){
        ModelMapper m=new ModelMapper();
        Diagnostico d=m.map(dto,Diagnostico.class);
        diagnosticoService.update(d);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        diagnosticoService.delete(id);
    }

    @GetMapping("/fecha")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<Diagnostico> diagnosticosPorFecha(@RequestParam("fechaInicio") LocalDate fechaInicio, @RequestParam("fechaFin") LocalDate fechaFin) {
        return diagnosticoService.buscarPorFecha(fechaInicio, fechaFin);
    }

    @GetMapping("/maxima-puntuacion")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<Diagnostico> diagnosticosConMaximaPuntuacion() {
        return diagnosticoService.listarDiagnosticosConPuntuacionMaximaPorUsuario();
    }

    @GetMapping("/promedio-puntuacion/{idCentroMedico}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String obtenerPromedioPuntuacionPorCentroMedico(@PathVariable("idCentroMedico") int idCentroMedico) {
        return diagnosticoService.obtenerPromedioPuntuacionPorCentroMedico(idCentroMedico);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Cliente','Especialista','ADMIN')")
// Agregar un get mapping porque estamos recuperando un registro por id cambiante (VARÍA)
    public DiagnosticoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        DiagnosticoDTO dto = m.map(diagnosticoService.listId(id), DiagnosticoDTO.class);
        return dto;
    }

}


