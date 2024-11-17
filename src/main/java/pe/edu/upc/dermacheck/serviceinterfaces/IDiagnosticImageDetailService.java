package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.entities.DiagnostImage;

import java.util.List;

public interface IDiagnosticImageDetailService {
    public void insert(DiagnostImage diagnostImage);

    public List<DiagnostImage> list();

    public void delete(int id);

    public DiagnostImage listId(int id);

    public List<DiagnostImage> allImageForDiagnostic(int id);
}
