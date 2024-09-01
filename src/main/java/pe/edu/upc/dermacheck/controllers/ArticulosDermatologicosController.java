package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.dermacheck.entities.ArticulosDermatologicos;
import pe.edu.upc.dermacheck.serviceinterfaces.IArticulosDermatologicosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articulosdermatologicos")
public class ArticulosDermatologicosController {
    @Autowired
    private IArticulosDermatologicosService articulosDermatologicosService;

    // Comentario 123
    @GetMapping

    public List<ArticulosDermatologicos> listar() {
        return articulosDermatologicosService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, ArticulosDermatologicos.class);
        }).collect(Collectors.toList());
    }
}
