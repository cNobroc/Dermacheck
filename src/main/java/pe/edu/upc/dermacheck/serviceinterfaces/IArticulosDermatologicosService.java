package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.entities.ArticulosDermatologicos;

import java.util.List;

public interface IArticulosDermatologicosService {
    public List<ArticulosDermatologicos> list();
    public void insert(ArticulosDermatologicos articulosDermatologicos);
    public  void update(ArticulosDermatologicos articulosDermatologicos);
    public List<ArticulosDermatologicos> buscar (String nombre);
    public void delete(int id);
}
