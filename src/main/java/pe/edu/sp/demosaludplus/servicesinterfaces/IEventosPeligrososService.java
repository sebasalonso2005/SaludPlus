package pe.edu.sp.demosaludplus.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.EventosPeligrosos;

import java.time.LocalDateTime;
import java.util.List;

public interface IEventosPeligrososService {
    public List<EventosPeligrosos>list();
    public void insert(EventosPeligrosos eventosPeligrosos);

    public EventosPeligrosos listId(int id);
    public void delete(int id);
    public void update(EventosPeligrosos eventosPeligrosos);
    public List<EventosPeligrosos> buscarPorTipo(@Param("tipo") String tipo);
    public List<EventosPeligrosos> buscarPorFecha(@Param("fecha") LocalDateTime fecha);
    public List<Object[]> contarUsuariosPorTipo(@Param("tipo") String tipo);
    public List<Object[]> contarEventosPorFecha();

}
