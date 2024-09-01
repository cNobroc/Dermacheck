package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.dermacheck.dtos.CentroMedicosDTO;
import pe.edu.upc.dermacheck.serviceinterfaces.ICentroMedicosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/centrosmedicos")
public class CentroMedicosControler {
    @Autowired
    private ICentroMedicosService cS;

    @GetMapping

    public List<CentroMedicosDTO> ListarCentrosMedicos() {
        return cS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, CentroMedicosDTO.class);
        }).collect(Collectors.toList());
    }

}
