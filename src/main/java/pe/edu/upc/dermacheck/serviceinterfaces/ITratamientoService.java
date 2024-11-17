package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.entities.Tratamiento;

import java.time.LocalDate;
import java.util.List;

public interface ITratamientoService {
    List<Tratamiento> list();

    public void insert(Tratamiento tratamiento);

    public void update(Tratamiento tratamiento);

    public void delete(int id);

    public Tratamiento listId(int id);

    List<Tratamiento> buscarPorFechaInicio(LocalDate fecha);
}

