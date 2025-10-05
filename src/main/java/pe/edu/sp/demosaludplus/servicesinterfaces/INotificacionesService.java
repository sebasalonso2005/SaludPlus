package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.sp.demosaludplus.Entities.Notificaciones;

import java.util.List;

public interface INotificacionesService {
    public List<Notificaciones> list();
    public void insert(Notificaciones n);
    public Notificaciones listId(int id);
    public void update(Notificaciones n);
    public void delete(int id);

    public List<Notificaciones> listByUsuario(int idUsuario);
    public List<Notificaciones> listNoLeidas(int idUsuario);
    public long countNoLeidas(int idUsuario);
}