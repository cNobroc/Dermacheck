package pe.edu.upc.dermacheck.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.dermacheck.entities.Tratamiento;
import pe.edu.upc.dermacheck.entities.Usuario;
import pe.edu.upc.dermacheck.repositories.ITratamientoRepository;
import pe.edu.upc.dermacheck.serviceinterfaces.ITratamientoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class TratamientoServiceImplement implements ITratamientoService {
    @Autowired
    private ITratamientoRepository tratamientoRepository;

    @Override
    public List<Tratamiento> list() {
        return tratamientoRepository.findAll();
    }

    @Override
    public void insert(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public void update(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public void delete(int id) {
        tratamientoRepository.deleteById(id);
    }

    @Override
    public List<Tratamiento> buscarPorFechaInicio(LocalDate fechaInicio) {
        return tratamientoRepository.buscarPorFechaInicio(fechaInicio);
    }


}
