package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.Medicamentos;
import pe.edu.sp.demosaludplus.repositories.MedicamentosRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IMedicamentosService;

import java.util.List;

@Service
public class MedicamentosServiceImplement implements IMedicamentosService {

    @Autowired
    private MedicamentosRepository repository;

    @Override
    public List<Medicamentos> list() { return repository.findAll(); }

    @Override
    public void insert(Medicamentos m) { repository.save(m); }

    @Override
    public Medicamentos listId(int id) { return repository.findById(id).orElse(null); }

    @Override
    public void update(Medicamentos m) { repository.save(m); }

    @Override
    public void delete(int id) { repository.deleteById(id); }

    @Override
    public List<Medicamentos> listByCita(int idCita) {
        return repository.listarPorCita(idCita);
    }
}

