package pe.edu.upc.dermacheck.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.dermacheck.entities.DiagnosticoxTratamiento;
import pe.edu.upc.dermacheck.entities.DiagnosticoxTratamientoId;
import pe.edu.upc.dermacheck.repositories.IDiagnosticoxTratamientoRepository;
import pe.edu.upc.dermacheck.serviceinterfaces.IDiagnosticoxTratamientoService;

import java.util.List;

@Service
public class DiagnosticoxTratamientoServiceImplement implements IDiagnosticoxTratamientoService {
    @Autowired
    private IDiagnosticoxTratamientoRepository diagnosticoxTratamientoRepository;

    @Override
    public List<DiagnosticoxTratamiento> list() {
        return diagnosticoxTratamientoRepository.findAll();
    }

    @Override
    public void insert(DiagnosticoxTratamiento diagnosticoxTratamiento) {
        diagnosticoxTratamientoRepository.save(diagnosticoxTratamiento);
    }

    @Override
    public void update(DiagnosticoxTratamiento diagnosticoxTratamiento) {
        if (diagnosticoxTratamientoRepository.existsById(diagnosticoxTratamiento.getId())) {
            diagnosticoxTratamientoRepository.save(diagnosticoxTratamiento);
        }
    }

    @Override
    public void delete(int idDiagnostico, int idTratamiento) {
        DiagnosticoxTratamientoId id = new DiagnosticoxTratamientoId(idDiagnostico, idTratamiento);
        diagnosticoxTratamientoRepository.deleteById(id);
    }
}
