package pe.edu.upc.dermacheck.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.dermacheck.entities.Recuperacion;
import pe.edu.upc.dermacheck.repositories.IEnfermedadRepository;
import pe.edu.upc.dermacheck.repositories.IRecuperacionRepository;
import pe.edu.upc.dermacheck.serviceinterfaces.IRecuperacionService;

import java.util.List;
@Service
public class RecuperacionServiceImplement implements IRecuperacionService {
    @Autowired
    private IRecuperacionRepository rR;
    @Override
    public List<Recuperacion> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Recuperacion recuperacion) {
    rR.save(recuperacion);
    }

    @Override
    public void update(Recuperacion recuperacion) {
    rR.save(recuperacion);
    }

    @Override
    public void delete(int id) {
    rR.deleteById(id);
    }
}
