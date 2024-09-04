package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.RecuperacionDTO;
import pe.edu.upc.dermacheck.entities.Recuperacion;
import pe.edu.upc.dermacheck.serviceinterfaces.IRecuperacionService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/Recuperaciones")
public class RecuperacionController {
    @Autowired

    private IRecuperacionService rS;

    @GetMapping
    public List<RecuperacionDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecuperacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody RecuperacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Recuperacion re = m.map(dto, Recuperacion.class);
        rS.insert(re);
    }

    @PatchMapping
    public void modificar(@RequestBody RecuperacionDTO dto){
        ModelMapper m=new ModelMapper();
        Recuperacion re=m.map(dto,Recuperacion.class);
        rS.update(re);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){

        rS.delete(id);
    }
}
