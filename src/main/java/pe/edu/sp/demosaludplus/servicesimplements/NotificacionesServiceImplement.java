package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.Notificaciones;
import pe.edu.sp.demosaludplus.Repositories.INotificacionesRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.INotificacionesService;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionesServiceImplement implements INotificacionesService {
    @Autowired
    private INotificacionesRepository nN;
    @Override
    public List<Notificaciones> list() {
        return nN.findAll();
    }

    @Override
    public void insert(Notificaciones notificaciones) {
        nN.save(notificaciones);
    }

    @Override
    public Notificaciones listId(int id) {
        return nN.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        nN.deleteById(id);
    }

    @Override
    public void update(Notificaciones notificaciones) {
        nN.save(notificaciones);
    }

    @Override
    public Optional<Notificaciones> buscarPorIdNotificaciones(Integer idNotificacion) {
        return nN.buscarPorIdNotificaciones(idNotificacion);
    }

    @Override
    public List<String[]> cantidadNotificacionesPorUsuario(Integer idUsuario) {
        return nN.cantidadNotificacionesPorUsuario(idUsuario);
    }
}
