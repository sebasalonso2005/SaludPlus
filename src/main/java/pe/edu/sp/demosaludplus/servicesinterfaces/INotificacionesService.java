package pe.edu.sp.demosaludplus.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.Notificaciones;

import java.util.List;
import java.util.Optional;

public interface INotificacionesService {
    public List<Notificaciones>list();
    public void insert(Notificaciones notificaciones);

    public Notificaciones listId(int id);
    public void delete(int id);
    public void update(Notificaciones notificaciones);
    public Optional<Notificaciones> buscarPorIdNotificaciones(@Param("idNotificacion") Integer idNotificacion);
    public List<String[]> cantidadNotificacionesPorUsuario(@Param("idUsuario") Integer idUsuario);

}
