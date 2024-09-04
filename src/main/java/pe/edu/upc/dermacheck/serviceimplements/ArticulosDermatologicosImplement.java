package pe.edu.upc.dermacheck.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.dermacheck.entities.ArticulosDermatologicos;
import pe.edu.upc.dermacheck.repositories.IArticulosDermatologicosRepository;
import pe.edu.upc.dermacheck.serviceinterfaces.IArticulosDermatologicosService;

import java.util.List;

@Service
public class ArticulosDermatologicosImplement implements IArticulosDermatologicosService {
    @Autowired
    private IArticulosDermatologicosRepository aS;

    @Override
    public List<ArticulosDermatologicos> list() {
        return aS.findAll();
    }

    @Override
    public void insert(ArticulosDermatologicos articulosDermatologicos) {
        aS.save(articulosDermatologicos);
    }

    @Override
    public void update(ArticulosDermatologicos articulosDermatologicos) {
    aS.save(articulosDermatologicos);
    }

    @Override
    public void delete(int id) {
    aS.deleteById(id);
    }
}
