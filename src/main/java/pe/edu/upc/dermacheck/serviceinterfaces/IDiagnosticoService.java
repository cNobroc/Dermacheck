package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.entities.Diagnostico;
import pe.edu.upc.dermacheck.entities.Rol;

import java.time.LocalDate;
import java.util.List;

public interface IDiagnosticoService {
    public List<Diagnostico> list();
    public void insert(Diagnostico diagnostico);
    public  void update(Diagnostico diagnostico );
    public void delete(int id);
    List<Diagnostico> listarDiagnosticosPorFecha(LocalDate fecha_inicio, LocalDate fecha_fin);

}
