package pe.edu.upc.dermacheck.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.dermacheck.entities.DiagnostImage;
import pe.edu.upc.dermacheck.repositories.IDiagnosticImageRepository;
import pe.edu.upc.dermacheck.serviceinterfaces.IDiagnosticImageDetailService;

import java.util.List;

@Service
public class DiagnosticImageServiceImplement implements IDiagnosticImageDetailService {

    @Autowired
    private IDiagnosticImageRepository dR;
    @Override
    public void insert(DiagnostImage diagnostImage) {
        dR.save(diagnostImage);
    }

    @Override
    public List<DiagnostImage> list() {
        return dR.findAll();
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public DiagnostImage listId(int id) {
        return dR.findById(id).orElse(new DiagnostImage());
    }

    @Override
    public List<DiagnostImage> allImageForDiagnostic(int id) {
        return dR.allImageForDiagnostic(id);
    }
}
