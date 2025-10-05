package pe.edu.sp.demosaludplus.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.EventosPeligrosos;
import pe.edu.sp.demosaludplus.repositories.EventosPeligrososRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IEventosPeligrososService;

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
