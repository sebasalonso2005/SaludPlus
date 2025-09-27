package pe.edu.sp.demosaludplus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.EventosPeligrosos;

import java.time.LocalDateTime;
import java.util.List;

public interface IEventosPeligrososRepository  extends JpaRepository<EventosPeligrosos, Integer> {
    //busca por el tipo
    @Query(value = "select * from eventos_peligrosos e where e.tipo = :tipo", nativeQuery = true)
    public List<EventosPeligrosos> buscarPorTipo(@Param("tipo") String tipo);

    //busca por fecha y te da todos los eventos peligrosos registrados
    @Query(value = "SELECT * FROM eventos_peligrosos e WHERE e.fecha = :fecha", nativeQuery = true)
    public List<EventosPeligrosos> buscarPorFecha(@Param("fecha") LocalDateTime fecha);

    // al poner el tipo te sale la cantidad de usuarios involucrados
    @Query(value = "SELECT e.tipo, COUNT(DISTINCT e.id_usuario) AS cantidad_usuarios " +
            "FROM eventos_peligrosos e " +
            "WHERE e.tipo = :tipo " +
            "GROUP BY e.tipo", nativeQuery = true)
    public List<Object[]> contarUsuariosPorTipo(@Param("tipo") String tipo);

    //muestra la fecha y la cantidad de eventos peligrosos ocurridos
    @Query(value = "SELECT fecha, COUNT(*) AS cantidad " +
            "FROM eventos_peligrosos " +
            "GROUP BY fecha " +
            "ORDER BY fecha", nativeQuery = true)
    public List<Object[]> contarEventosPorFecha();
}
