package pe.edu.upc.dermacheck.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.dermacheck.entities.Anuncio;
import pe.edu.upc.dermacheck.repositories.IAnuncioRepository;
import pe.edu.upc.dermacheck.serviceinterfaces.IAnunciosService;

import java.util.List;

@Service
public class AnuncioServiceImplement implements IAnunciosService {
    @Autowired
    private IAnuncioRepository anuncioRepository;

    @Override
    public List<Anuncio> list() {
        return anuncioRepository.findAll();
    }

    @Override
    public void insert(Anuncio anuncio) {
        anuncioRepository.save(anuncio);
    }

    @Override
    public void update(Anuncio anuncio) {
        anuncioRepository.save(anuncio);

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<String[]> CantidadAnunciosPorUsuario() {
        return anuncioRepository.AnunciosXUsuario();
    }

}
