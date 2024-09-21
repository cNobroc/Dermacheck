package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.entities.Enfermedad;


import java.util.List;

public interface IEnfermedadService {
    public List<Enfermedad> list();
    public void insert(Enfermedad enfermedad);
    public  void update(Enfermedad enfermedad);
    public void delete(int id);

}
