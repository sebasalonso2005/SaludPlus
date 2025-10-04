package pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces;

import pe.edu.upc.demoSaludPlusNuevo.entities.Usuarios;
import java.util.List;

public interface IUsuariosService {
    public List<Usuarios> list();
    public void insert(Usuarios u);
    public Usuarios listId(int id);
    public void update(Usuarios u);
    public void delete(int id);

    public List<Usuarios> searchByComunidad(String comunidad);
}