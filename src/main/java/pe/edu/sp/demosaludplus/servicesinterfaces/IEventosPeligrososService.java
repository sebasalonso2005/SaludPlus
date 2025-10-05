package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.sp.demosaludplus.Entities.EventosPeligrosos;

import java.time.LocalDateTime;
import java.util.List;

public interface IEventosPeligrososService {
    public List<EventosPeligrosos> list();
    public void insert(EventosPeligrosos e);
    public EventosPeligrosos listId(int id);
    public void update(EventosPeligrosos e);
    public void delete(int id);

    public List<EventosPeligrosos> listByUsuario(int idUsuario);
    public List<EventosPeligrosos> searchByUsuarioYFecha(int idUsuario, LocalDateTime desde, LocalDateTime hasta);
}