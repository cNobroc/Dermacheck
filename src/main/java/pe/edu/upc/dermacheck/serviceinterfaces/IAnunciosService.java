package pe.edu.upc.dermacheck.serviceinterfaces;

import pe.edu.upc.dermacheck.entities.Anuncio;

import java.util.List;

public interface IAnunciosService {
    public List<Anuncio> list();

    public void insert(Anuncio anuncio);

    public void update(Anuncio anuncio);

    public void delete(int id);

    public List<String[]> CantidadAnunciosPorUsuario();

    public List<String[]> IngresosPorAnuncio();

    public Anuncio listId(int id);

}
