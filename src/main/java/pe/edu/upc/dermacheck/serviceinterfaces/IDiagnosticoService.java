package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.entities.Diagnostico;

import java.time.LocalDate;
import java.util.List;

public interface IDiagnosticoService {
    public List<Diagnostico> list();

    public void insert(Diagnostico diagnostico);

    public void update(Diagnostico diagnostico);

    public void delete(int id);

    public List<Diagnostico> buscarPorFecha(LocalDate fechaInicio, LocalDate fechaFin);

    public List<Diagnostico> listarDiagnosticosConPuntuacionMaximaPorUsuario();

    public String obtenerPromedioPuntuacionPorCentroMedico(int idCentroMedico);

    public Diagnostico listId(int id);

}
