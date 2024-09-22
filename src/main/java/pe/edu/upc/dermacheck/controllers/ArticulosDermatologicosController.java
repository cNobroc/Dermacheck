package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.ArticulosDermatologicosDTO;
import pe.edu.upc.dermacheck.entities.ArticulosDermatologicos;
import pe.edu.upc.dermacheck.serviceinterfaces.IArticulosDermatologicosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articulos-dermatologicos")
@PreAuthorize("hasAnyAuthority('ADMIN', 'Especialista', 'Usuario')")

public class ArticulosDermatologicosController {
    @Autowired
    private IArticulosDermatologicosService aS;

    @GetMapping

    public List<ArticulosDermatologicos> listar() {
        return aS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, ArticulosDermatologicos.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody ArticulosDermatologicosDTO dto) {
        ModelMapper m = new ModelMapper();
        ArticulosDermatologicos ar = m.map(dto, ArticulosDermatologicos.class);
        aS.insert(ar);
    }

    @PatchMapping
    public void modificar(@RequestBody ArticulosDermatologicosDTO dto){
        ModelMapper m=new ModelMapper();
        ArticulosDermatologicos ar=m.map(dto,ArticulosDermatologicos.class);
        aS.update(ar);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){

        aS.delete(id);
    }
    @GetMapping("/busquedas")
    public List<ArticulosDermatologicosDTO> buscar (@RequestParam String nombre){
        return aS.buscar(nombre).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ArticulosDermatologicosDTO.class);
        }).collect(Collectors.toList());
    }
}
