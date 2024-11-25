package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.AnuncioDTO;
import pe.edu.upc.dermacheck.dtos.AnuncioxUsuarioDTO;
import pe.edu.upc.dermacheck.dtos.IngresosxAnuncioDTO;
import pe.edu.upc.dermacheck.entities.Anuncio;
import pe.edu.upc.dermacheck.serviceinterfaces.IAnunciosService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/anuncio")
@PreAuthorize("hasAnyAuthority('ADMIN')")

public class AnuncioController {
    @Autowired
    private IAnunciosService anunciosService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Empresas anunciantes','ADMIN')")
    public List<Anuncio> listar() {
        return anunciosService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, Anuncio.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('Empresas anunciantes','ADMIN')")
    public void registrar (@RequestBody AnuncioDTO anuncioDTO) {
        ModelMapper m = new ModelMapper();
        Anuncio anuncio = m.map(anuncioDTO, Anuncio.class);
        anunciosService.insert(anuncio);
    }

    @PatchMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void modificar(@RequestBody AnuncioDTO dto) {
        ModelMapper m = new ModelMapper();
        Anuncio anuncio = m.map(dto, Anuncio.class);
        anunciosService.update(anuncio);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Empresas anunciantes','ADMIN')")
    public void eliminar (@PathVariable("id") Integer id) {
        anunciosService.delete(id);
    }

    @GetMapping("/AnunciosxUsuarios")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
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

    @GetMapping("/IngresosPorAnuncio")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<IngresosxAnuncioDTO> obtenerIngresosPorAnuncio() {
        List<String[]> lista = anunciosService.IngresosPorAnuncio();
        List<IngresosxAnuncioDTO> listaDTO = new ArrayList<>();

        for (String[] columna : lista) {
            IngresosxAnuncioDTO dto = new IngresosxAnuncioDTO();
            dto.setNombres (columna[0]);
            dto.setIngresos(Double.parseDouble(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Empresas anunciantes','ADMIN')")
// Agregar un get mapping porque estamos recuperando un registro por id cambiante (VARÍA)
    public AnuncioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        AnuncioDTO dto = m.map(anunciosService.listId(id), AnuncioDTO.class);
        return dto;
    }

}
