package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.entities.Enfermedad;
import pe.edu.upc.dermacheck.entities.Recuperacion;

import java.util.List;

public interface IRecuperacionService {
    public List<Recuperacion> list();
    public void insert(Recuperacion recuperacion);
    public  void update(Recuperacion recuperacion);
    public void delete(int id);
    public List<String[]> RecuperacionesPorUsuario();
}
