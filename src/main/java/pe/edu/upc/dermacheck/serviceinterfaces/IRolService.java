package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> list();

    public void insert(Rol rol);

    public void update(Rol rol);

}
