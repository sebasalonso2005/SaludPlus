package pe.edu.sp.demosaludplus.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.Roles;

import java.util.List;

public interface IRolesService {
    public List<Roles>list();
    public void insert(Roles roles);

    public Roles listId(int id);
    public void delete(int id);
    public void update(Roles roles);
    public int contarUsuariosPorRol(@Param("rol") String rol);

}
