package pe.edu.sp.demosaludplus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.Notificaciones;

import java.util.List;
import java.util.Optional;

public interface INotificacionesRepository extends JpaRepository<Notificaciones, Integer> {
    //este query busca por idnotificaciones
    @Query("select n from Notificaciones n where n.idNotificacion = :idNotificacion")
    public Optional<Notificaciones> buscarPorIdNotificaciones(@Param("idNotificacion") Integer idNotificacion);

    // este query mostrar la cantidad de notificaciones que tiene un usuario
    //en el postgre me sale error
    @Query(value = "select u.usuario, count(n.idNotificacion) " +
            "from usuarios u inner join notificaciones n " +
            "on u.idUsuario = n.idUsuario " +
            "where u.idUsuario = :idUsuario " +
            "group by u.usuario", nativeQuery = true)
    public List<String[]> cantidadNotificacionesPorUsuario(@Param("idUsuario") Integer idUsuario);
}
