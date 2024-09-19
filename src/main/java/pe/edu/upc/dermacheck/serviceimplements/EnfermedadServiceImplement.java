package pe.edu.upc.dermacheck.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.dermacheck.entities.Enfermedad;
import pe.edu.upc.dermacheck.repositories.IEnfermedadRepository;
import pe.edu.upc.dermacheck.serviceinterfaces.IEnfermedadService;

import java.util.List;
@Service
public class EnfermedadServiceImplement implements IEnfermedadService {
    @Autowired
    private IEnfermedadRepository eR;
    @Override
    public List<Enfermedad> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Enfermedad enfermedad) {
        eR.save(enfermedad);
    }


    @Override
    public void update(Enfermedad enfermedad) {
        eR.save(enfermedad);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }
}
