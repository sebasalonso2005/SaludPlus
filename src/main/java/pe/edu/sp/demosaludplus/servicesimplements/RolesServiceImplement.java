package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.Roles;
import pe.edu.sp.demosaludplus.Repositories.IRolesRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IRolesService;

import java.util.List;
@Service
public class RolesServiceImplement implements IRolesService {
    @Autowired
    private IRolesRepository rR;
    @Override
    public List<Roles> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Roles roles) {
        rR.save(roles);
    }

    @Override
    public Roles listId(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public void update(Roles roles) {
        rR.save(roles);
    }

    @Override
    public int contarUsuariosPorRol(String rol) {
        return rR.contarUsuariosPorRol(rol);
    }
}
