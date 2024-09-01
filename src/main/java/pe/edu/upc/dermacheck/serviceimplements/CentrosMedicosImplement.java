package pe.edu.upc.dermacheck.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.dermacheck.entities.CentrosMedicos;
import pe.edu.upc.dermacheck.repositories.ICentrosMedicosRepository;
import pe.edu.upc.dermacheck.serviceinterfaces.ICentroMedicosService;


import java.util.List;

@Service
public class CentrosMedicosImplement implements ICentroMedicosService{
    @Autowired
    private ICentrosMedicosRepository CR;

    @Override
    public List<CentrosMedicos> list(){
        return CR.findAll();
    }
}
