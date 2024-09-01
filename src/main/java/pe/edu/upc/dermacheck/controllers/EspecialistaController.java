package pe.edu.upc.dermacheck.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.dermacheck.dtos.RolDTO;
import pe.edu.upc.dermacheck.entities.Especialista;
import pe.edu.upc.dermacheck.serviceinterfaces.IEspecialistaService;
import pe.edu.upc.dermacheck.serviceinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/especialista")
public class EspecialistaController {
    @Autowired
    private IEspecialistaService especialistaService;

    @GetMapping

    public List<Especialista> listar() {
        return especialistaService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, Especialista.class);
        }).collect(Collectors.toList());
    }
}
