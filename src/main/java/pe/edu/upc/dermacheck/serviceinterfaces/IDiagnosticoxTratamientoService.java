package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.entities.DiagnosticoxTratamiento;

import java.util.List;

public interface IDiagnosticoxTratamientoService {
    public List<DiagnosticoxTratamiento> list();
    public void insert(DiagnosticoxTratamiento diagnosticoxTratamiento);
    public  void update(DiagnosticoxTratamiento diagnosticoxTratamiento );
    public void delete(int id);
    List<String[]> MaterialesMedicinalesxUsuario();
}
