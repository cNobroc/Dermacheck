package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.entities.CentrosMedicos;

import java.util.List;

public interface ICentroMedicosService {
    public List<CentrosMedicos> list();
    public void insert(CentrosMedicos centrosMedicos);
    public  void update(CentrosMedicos centrosMedicos);
    public void delete(int id);
}
