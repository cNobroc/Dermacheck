package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.entities.DiagnosticoxTratamiento;

import java.util.List;

public interface IDiagnosticoxTratamientoService {
    List<DiagnosticoxTratamiento> list();
    void insert(DiagnosticoxTratamiento diagnosticoxTratamiento);
    void update(DiagnosticoxTratamiento diagnosticoxTratamiento);
    void delete(int idDiagnostico, int idTratamiento);
}
