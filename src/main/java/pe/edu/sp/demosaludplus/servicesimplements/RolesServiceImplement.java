package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoSaludPlusNuevo.entities.Roles;
import pe.edu.upc.demoSaludPlusNuevo.repositories.RolesRepository;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.IRolesService;

import java.util.List;

@Service
public class RolesServiceImplement implements IRolesService {

    @Autowired
    private RolesRepository repository;

    @Override
    public List<Roles> list() { return repository.findAll(); }

    @Override
    public void insert(Roles r) { repository.save(r); }

    @Override
    public Roles listId(int id) { return repository.findById(id).orElse(null); }

    @Override
    public void update(Roles r) { repository.save(r); }

    @Override
    public void delete(int id) { repository.deleteById(id); }
}