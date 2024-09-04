package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.dtos.UsuarioDiagnosticoDTO;
import pe.edu.upc.dermacheck.entities.Tratamiento;
import pe.edu.upc.dermacheck.entities.Usuario;

import java.util.List;

public interface ITratamientoService {
    List<Tratamiento> list();
    public void insert(Tratamiento tratamiento);
    public void update(Tratamiento tratamiento);
    public void delete(int id);

}

