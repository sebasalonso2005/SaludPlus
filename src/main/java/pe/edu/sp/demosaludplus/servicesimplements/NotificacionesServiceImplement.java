package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoSaludPlusNuevo.entities.Notificaciones;
import pe.edu.upc.demoSaludPlusNuevo.repositories.NotificacionesRepository;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.INotificacionesService;

import java.util.List;

@Service
public class NotificacionesServiceImplement implements INotificacionesService {

    @Autowired
    private NotificacionesRepository repository;

    @Override
    public List<Notificaciones> list() { return repository.findAll(); }

    @Override
    public void insert(Notificaciones n) { repository.save(n); }

    @Override
    public Notificaciones listId(int id) { return repository.findById(id).orElse(null); }

    @Override
    public void update(Notificaciones n) { repository.save(n); }

    @Override
    public void delete(int id) { repository.deleteById(id); }

    @Override
    public List<Notificaciones> listByUsuario(int idUsuario) {
        // últimas 20 ordenadas por fecha
        return repository.findTop20ByUsuarioIdUsuarioOrderByFechaEnvioDesc(idUsuario);
    }

    @Override
    public List<Notificaciones> listNoLeidas(int idUsuario) {
        return repository.listarNoLeidas(idUsuario);
    }

    @Override
    public long countNoLeidas(int idUsuario) {
        return repository.countByUsuarioIdUsuarioAndLeidoFalse(idUsuario);
    }
}