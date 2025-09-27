package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.EventosPeligrosos;
import pe.edu.sp.demosaludplus.Repositories.IEventosPeligrososRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IEventosPeligrososService;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class EventosPeligrososServiceImplement implements IEventosPeligrososService {
    @Autowired
    private IEventosPeligrososRepository eP;
    @Override
    public List<EventosPeligrosos> list() {
        return eP.findAll();
    }

    @Override
    public void insert(EventosPeligrosos eventosPeligrosos) {
        eP.save(eventosPeligrosos);
    }

    @Override
    public EventosPeligrosos listId(int id) {
        return eP.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        eP.deleteById(id);
    }

    @Override
    public void update(EventosPeligrosos eventosPeligrosos) {
        eP.save(eventosPeligrosos);
    }

    @Override
    public List<EventosPeligrosos> buscarPorTipo(String tipo) {
        return eP.buscarPorTipo(tipo);
    }

    @Override
    public List<EventosPeligrosos> buscarPorFecha(LocalDateTime fecha) {
        return eP.buscarPorFecha(fecha);
    }

    @Override
    public List<Object[]> contarUsuariosPorTipo(String tipo) {
        return eP.contarUsuariosPorTipo(tipo);
    }

    @Override
    public List<Object[]> contarEventosPorFecha() {
        return eP.contarEventosPorFecha();
    }
}
