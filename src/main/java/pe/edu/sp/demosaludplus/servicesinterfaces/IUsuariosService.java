package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.sp.demosaludplus.Entities.Usuarios;

import java.util.List;

public interface IUsuariosService {
    public List<Usuarios> list();
    public void insert(Usuarios u);
    public Usuarios listId(int id);
    public void update(Usuarios u);
    public void delete(int id);

    public List<Usuarios> searchByComunidad(String comunidad);
}