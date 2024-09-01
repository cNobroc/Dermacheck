package pe.edu.upc.dermacheck.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.dermacheck.entities.Especialista;
import pe.edu.upc.dermacheck.repositories.IEspecialistaRepository;
import pe.edu.upc.dermacheck.serviceinterfaces.IEspecialistaService;

import java.util.List;

@Service
public class EspecialistaServiceImplement implements IEspecialistaService {
    @Autowired
    private IEspecialistaRepository especialistaRepository;

    @Override
    public List<Especialista> list (){
        return especialistaRepository.findAll();
    }

}
