package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.EnfermedadDTO;
import pe.edu.upc.dermacheck.entities.Enfermedad;
import pe.edu.upc.dermacheck.serviceinterfaces.IEnfermedadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enfermedades")
@PreAuthorize("hasAuthority('ADMIN')")

public class EnfermedadController {
    @Autowired

    private IEnfermedadService eS;

    @GetMapping
    public List<EnfermedadDTO> listar() {
        return eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EnfermedadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody EnfermedadDTO dto) {
        ModelMapper m = new ModelMapper();
        Enfermedad en = m.map(dto, Enfermedad.class);
        eS.insert(en);
    }

    @PatchMapping
    public void modificar(@RequestBody EnfermedadDTO dto){
        ModelMapper m=new ModelMapper();
        Enfermedad en=m.map(dto,Enfermedad.class);
        eS.update(en);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){

        eS.delete(id);
    }
}
