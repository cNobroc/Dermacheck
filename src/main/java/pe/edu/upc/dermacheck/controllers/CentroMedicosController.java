package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.CentroMedicosDTO;
import pe.edu.upc.dermacheck.entities.CentrosMedicos;
import pe.edu.upc.dermacheck.serviceinterfaces.ICentroMedicosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/centros-medicos")
@PreAuthorize("hasAnyAuthority('ADMIN')")

public class CentroMedicosController {
    @Autowired
    private ICentroMedicosService cS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Especialista','Usuario','ADMIN')")
    public List<CentroMedicosDTO> ListarCentrosMedicos() {
        return cS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, CentroMedicosDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void registrar(@RequestBody CentroMedicosDTO dto){
        ModelMapper m=new ModelMapper();
        CentrosMedicos cm = m.map(dto,CentrosMedicos.class);
        cS.insert(cm);
    }
    @PatchMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void modificar(@RequestBody  CentroMedicosDTO dto){
        ModelMapper m=new ModelMapper();
        CentrosMedicos cm=m.map(dto,CentrosMedicos.class);
        cS.update(cm);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        cS.delete(id);
    }

    @GetMapping("/diagnosticos")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<String> obtenerCentrosConMasDiagnosticos(@RequestParam("cantidad") int cantidad) {
        return cS.obtenerCentrosCantidadDiagnosticos(cantidad);
    }


}
