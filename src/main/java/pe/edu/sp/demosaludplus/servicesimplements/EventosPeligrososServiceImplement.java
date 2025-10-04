package pe.edu.upc.demoSaludPlusNuevo.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoSaludPlusNuevo.entities.EventosPeligrosos;
import pe.edu.upc.demoSaludPlusNuevo.repositories.EventosPeligrososRepository;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.IEventosPeligrososService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventosPeligrososServiceImplement implements IEventosPeligrososService {

    @Autowired
    private EventosPeligrososRepository repository;

    @Override
    public List<EventosPeligrosos> list() { return repository.findAll(); }

    @Override
    public void insert(EventosPeligrosos e) { repository.save(e); }

    @Override
    public EventosPeligrosos listId(int id) { return repository.findById(id).orElse(null); }

    @Override
    public void update(EventosPeligrosos e) { repository.save(e); }

    @Override
    public void delete(int id) { repository.deleteById(id); }

    @Override
    public List<EventosPeligrosos> listByUsuario(int idUsuario) {
        return repository.findByUsuarioIdUsuario(idUsuario, Pageable.unpaged()).getContent();
    }

    @Override
    public List<EventosPeligrosos> searchByUsuarioYFecha(int idUsuario, LocalDateTime desde, LocalDateTime hasta) {
        return repository.buscarPorUsuarioYFecha(idUsuario, desde, hasta);
    }
}
