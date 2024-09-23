package pe.edu.upc.dermacheck.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.dermacheck.entities.Diagnostico;
import pe.edu.upc.dermacheck.repositories.IDiagnosticoRepository;
import pe.edu.upc.dermacheck.serviceinterfaces.IDiagnosticoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class DiagnosticoServiceImplement implements IDiagnosticoService {
    @Autowired
    private IDiagnosticoRepository diagnosticoRepository;

    @Override
    public List<Diagnostico> list() {
        return diagnosticoRepository.findAll();
    }

    @Override
    public void insert(Diagnostico diagnostico) {
        diagnosticoRepository.save(diagnostico);
    }

    @Override
    public void update(Diagnostico diagnostico) {
        diagnosticoRepository.save(diagnostico);
    }

    @Override
    public void delete(int id) {
        diagnosticoRepository.deleteById(id);
    }

    @Override
    public List<Diagnostico> buscarPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        return diagnosticoRepository.buscarPorFecha(fechaInicio, fechaFin);
    }

    @Override
    public List<Diagnostico> listarDiagnosticosConPuntuacionMaximaPorUsuario() {
        return diagnosticoRepository.buscarDiagnosticosConPuntuacionMaximaPorUsuario();
    }

    @Override
    public String obtenerPromedioPuntuacionPorCentroMedico(int idCentroMedico) {
        return diagnosticoRepository.obtenerPromedioPuntuacionPorCentroMedico(idCentroMedico);
    }


}
