package pe.edu.upc.dermacheck.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.dermacheck.dtos.DiagnosticoImageDTO;
import pe.edu.upc.dermacheck.entities.DiagnostImage;
import pe.edu.upc.dermacheck.serviceinterfaces.IDiagnosticImageDetailService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnosticoimagen")
public class DiagnosticoImageController {
    @Autowired
    private IDiagnosticImageDetailService dS;

    @GetMapping
    public List<DiagnosticoImageDTO> list(){
        return dS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, DiagnosticoImageDTO.class);
        }).collect(Collectors.toList());
    }



    @PostMapping
    public void insert(@RequestBody DiagnosticoImageDTO diagnosticoImageDTO){
        ModelMapper m = new ModelMapper();
        DiagnostImage dI = m.map(diagnosticoImageDTO, DiagnostImage.class);
        dS.insert(dI);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        dS.delete(id);
    }

    @PutMapping
    public void update(@RequestBody DiagnosticoImageDTO diagnosticoImageDTO){
        ModelMapper m = new ModelMapper();
        DiagnostImage dI = m.map(diagnosticoImageDTO, DiagnostImage.class);
        dS.insert(dI);
    }

    @GetMapping("/{id}")
    public DiagnosticoImageDTO listById(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        DiagnostImage dI= dS.listId(id);
        return m.map(dI, DiagnosticoImageDTO.class);
    }

    @GetMapping("/images/{id}")
    public List<DiagnosticoImageDTO> allDiagnosticImage(@PathVariable("id") Integer id){
        return dS.allImageForDiagnostic(id).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,DiagnosticoImageDTO.class);
        }).collect(Collectors.toList());
    }

}