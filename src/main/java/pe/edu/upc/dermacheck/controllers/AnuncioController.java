package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.AnuncioDTO;
import pe.edu.upc.dermacheck.entities.Anuncio;
import pe.edu.upc.dermacheck.serviceinterfaces.IAnunciosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/anuncios")
public class AnuncioController {
    @Autowired
    private IAnunciosService anunciosService;

    @GetMapping
    public List<Anuncio> listar() {
        return anunciosService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, Anuncio.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar (@RequestBody AnuncioDTO anuncioDTO) {
        ModelMapper m = new ModelMapper();
        Anuncio anuncio = m.map(anuncioDTO, Anuncio.class);
        anunciosService.insert(anuncio);
    }

    @PatchMapping
    public void modificar(@RequestBody AnuncioDTO dto) {
        ModelMapper m = new ModelMapper();
        Anuncio anuncio = m.map(dto, Anuncio.class);
        anunciosService.update(anuncio);
    }

    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable("id") Integer id) {
        anunciosService.delete(id);
    }

    @GetMapping("/anuncios-count")
    public List<Object[]> contarAnunciosPorUsuario() {
        return anunciosService.countAnunciosByUsuario();
    }
}
