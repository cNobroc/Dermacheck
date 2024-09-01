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
    private IArticulosDermatologicosRepository articulosDermatologicosRepository;

    @Override
    public List<ArticulosDermatologicos> list() {
        return articulosDermatologicosRepository.findAll();
    }
}
