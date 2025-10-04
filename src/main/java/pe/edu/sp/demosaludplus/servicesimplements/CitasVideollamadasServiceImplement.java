package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.servicesinterfaces.ICitasVideollamadasService;
import pe.edu.upc.demoSaludPlusNuevo.entities.CitasVideollamadas;
import pe.edu.upc.demoSaludPlusNuevo.repositories.CitasVideollamadasRepository;


import java.util.List;

@Service
public class CitasVideollamadasServiceImplement implements ICitasVideollamadasService {

    @Autowired
    private CitasVideollamadasRepository repository;

    @Override
    public List<CitasVideollamadas> list() { return repository.findAll(); }

    @Override
    public void insert(CitasVideollamadas c) { repository.save(c); }

    @Override
    public CitasVideollamadas listId(int id) { return repository.findById(id).orElse(null); }

    @Override
    public void update(CitasVideollamadas c) { repository.save(c); }

    @Override
    public void delete(int id) { repository.deleteById(id); }

    @Override
    public CitasVideollamadas findByCita(int idCita) {
        return repository.findByIdCita(idCita).orElse(null);
    }
}
