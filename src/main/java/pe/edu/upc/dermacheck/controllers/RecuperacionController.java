package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.RecuperacionDTO;
import pe.edu.upc.dermacheck.dtos.RecuperacionesxUsuarioDTO;
import pe.edu.upc.dermacheck.entities.Recuperacion;
import pe.edu.upc.dermacheck.serviceinterfaces.IRecuperacionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/recuperaciones")
@PreAuthorize("hasAuthority('ADMIN')")

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

    @GetMapping ("/RecuperacionesxUsuario")
    public List<RecuperacionesxUsuarioDTO> contarRecuperacionesPorUsuario() {
        List<String[]> lista = rS.RecuperacionesPorUsuario();
        List<RecuperacionesxUsuarioDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            RecuperacionesxUsuarioDTO dto = new RecuperacionesxUsuarioDTO();
            dto.setNombre(columna[0]);
            dto.setCount(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
