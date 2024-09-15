package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.AnuncioDTO;
import pe.edu.upc.dermacheck.dtos.AnuncioxUsuarioDTO;
import pe.edu.upc.dermacheck.entities.Anuncio;
import pe.edu.upc.dermacheck.serviceinterfaces.IAnunciosService;

import java.util.ArrayList;
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

    @GetMapping("/AnunciosxUsuarios")
    public List<AnuncioxUsuarioDTO> contarAnunciosPorUsuario() {
        List<String[]>lista=anunciosService.CantidadAnunciosPorUsuario();
            List<AnuncioxUsuarioDTO>listaDTO=new ArrayList<>();
                    for(String[]columna:lista){
                        AnuncioxUsuarioDTO dto=new AnuncioxUsuarioDTO();
                        dto.setNombres(columna[0]);
                        dto.setCount(Integer.parseInt(columna[1]));
                        listaDTO.add(dto);
                    }
        return listaDTO;
    }
}
