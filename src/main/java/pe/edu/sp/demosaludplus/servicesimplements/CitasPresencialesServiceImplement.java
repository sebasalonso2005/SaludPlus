package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.servicesinterfaces.ICitasPresencialesService;
import pe.edu.upc.demoSaludPlusNuevo.entities.CitasPresenciales;
import pe.edu.upc.demoSaludPlusNuevo.repositories.CitasPresencialesRepository;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.ICitasPresencialesService;

import java.util.List;

@Service
public class CitasPresencialesServiceImplement implements ICitasPresencialesService {

    @Autowired
    private CitasPresencialesRepository repository;

    @Override
    public List<CitasPresenciales> list() { return repository.findAll(); }

    @Override
    public void insert(CitasPresenciales c) { repository.save(c); }

    @Override
    public CitasPresenciales listId(int id) { return repository.findById(id).orElse(null); }

    @Override
    public void update(CitasPresenciales c) { repository.save(c); }

    @Override
    public void delete(int id) { repository.deleteById(id); }

    @Override
    public CitasPresenciales findByCita(int idCita) {
        return repository.findByIdCita(idCita).orElse(null);
    }
}