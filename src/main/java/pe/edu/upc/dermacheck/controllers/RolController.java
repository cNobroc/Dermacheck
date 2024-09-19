package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.RolDTO;
import pe.edu.upc.dermacheck.dtos.UsuarioDTO;
import pe.edu.upc.dermacheck.entities.Rol;
import pe.edu.upc.dermacheck.entities.Usuario;
import pe.edu.upc.dermacheck.serviceinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rol")
@PreAuthorize("hasAuthority('ADMIN')")

public class RolController {
    @Autowired
    private IRolService rolService;

    @GetMapping
    public List<RolDTO> listar() {
        return rolService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar (@RequestBody RolDTO rolDTO) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(rolDTO, Rol.class);
        rolService.insert(rol);
    }
    @PatchMapping
    public void modificar(@RequestBody RolDTO dto){
        ModelMapper m=new ModelMapper();
        Rol ro=m.map(dto,Rol.class);
        rolService.update(ro);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){

        rolService.delete(id);
    }
}


