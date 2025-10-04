package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.upc.demoSaludPlusNuevo.entities.Roles;
import java.util.List;

public interface IRolesService {
    public List<Roles> list();
    public void insert(Roles r);
    public Roles listId(int id);
    public void update(Roles r);
    public void delete(int id);
}