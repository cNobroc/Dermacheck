package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.TratamientoDTO;
import pe.edu.upc.dermacheck.entities.Tratamiento;
import pe.edu.upc.dermacheck.serviceinterfaces.ITratamientoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tratamientos")
@PreAuthorize("hasAnyAuthority('ADMIN', 'Especialista')")

public class TratamientoController {
    @Autowired
    private ITratamientoService tratamientoService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Usuario','Especialista')")
    public List<TratamientoDTO> listar() {
        return tratamientoService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, TratamientoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('Especialista')")
    public void registrar (@RequestBody TratamientoDTO tratamientoDTO) {
        ModelMapper m = new ModelMapper();
        Tratamiento tratamiento = m.map(tratamientoDTO, Tratamiento.class);
        tratamientoService.insert(tratamiento);
    }

    @PatchMapping
    public void modificar(@RequestBody TratamientoDTO dto) {
        ModelMapper m = new ModelMapper();
        Tratamiento tratamiento = m.map(dto, Tratamiento.class);
        tratamientoService.update(tratamiento);
    }

    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable("id") Integer id) {
        tratamientoService.delete(id);
    }

    @GetMapping("/por-fecha-inicio")
    public List<TratamientoDTO> buscarPorFechaInicio(@RequestParam("fechaInicio") LocalDate fechaInicio) {
        List<Tratamiento> tratamientos = tratamientoService.buscarPorFechaInicio(fechaInicio);
        return tratamientos.stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, TratamientoDTO.class);
        }).collect(Collectors.toList());
    }

}
