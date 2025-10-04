package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoSaludPlusNuevo.entities.HistoriasClinicas;
import pe.edu.upc.demoSaludPlusNuevo.repositories.HistoriasClinicasRepository;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.IHistoriasClinicasService;

import java.util.List;

@Service
public class HistoriasClinicasServiceImplement implements IHistoriasClinicasService {

    @Autowired
    private HistoriasClinicasRepository repository;

    @Override
    public List<HistoriasClinicas> list() { return repository.findAll(); }

    @Override
    public void insert(HistoriasClinicas h) { repository.save(h); }

    @Override
    public HistoriasClinicas listId(int id) { return repository.findById(id).orElse(null); }

    @Override
    public void update(HistoriasClinicas h) { repository.save(h); }

    @Override
    public void delete(int id) { repository.deleteById(id); }

    @Override
    public HistoriasClinicas findByCita(int idCita) {
        return repository.findByIdCita(idCita).orElse(null);
    }
}
