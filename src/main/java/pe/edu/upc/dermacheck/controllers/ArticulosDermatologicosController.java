package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.ArticulosDermatologicosDTO;
import pe.edu.upc.dermacheck.dtos.RevistasxUsuarioDTO;
import pe.edu.upc.dermacheck.entities.ArticulosDermatologicos;
import pe.edu.upc.dermacheck.serviceinterfaces.IArticulosDermatologicosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articulos-dermatologicos")
@PreAuthorize("hasAnyAuthority('ADMIN')")

public class ArticulosDermatologicosController {
    @Autowired
    private IArticulosDermatologicosService aS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Usuario','Especialista','ADMIN')")
    public List<ArticulosDermatologicos> listar() {
        return aS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, ArticulosDermatologicos.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('Especialista','ADMIN')")
    public void registrar(@RequestBody ArticulosDermatologicosDTO dto) {
        ModelMapper m = new ModelMapper();
        ArticulosDermatologicos ar = m.map(dto, ArticulosDermatologicos.class);
        aS.insert(ar);
    }

    @PatchMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void modificar(@RequestBody ArticulosDermatologicosDTO dto){
        ModelMapper m=new ModelMapper();
        ArticulosDermatologicos ar=m.map(dto,ArticulosDermatologicos.class);
        aS.update(ar);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){

        aS.delete(id);
    }
    @GetMapping("/busquedas")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<ArticulosDermatologicosDTO> buscar (@RequestParam String nombre){
        return aS.buscar(nombre).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ArticulosDermatologicosDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/RevistasPorUsuario")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<RevistasxUsuarioDTO> contarRevistasPorUsuario() {
        List<String[]> lista = aS.RevistasPorUsuario();

        List<RevistasxUsuarioDTO> listaDTO = lista.stream().map(columna -> {
            RevistasxUsuarioDTO dto = new RevistasxUsuarioDTO();
            dto.setNombre(columna[0]);
            dto.setCount(Integer.parseInt(columna[1]));
            return dto;
        }).collect(Collectors.toList());

        return listaDTO;
    }
}
