package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.sp.demosaludplus.Entities.Notificaciones;

import java.util.List;

@Repository
public interface NotificacionesRepository extends JpaRepository<Notificaciones, Integer> {

    Page<Notificaciones> findByUsuarioIdUsuarioOrderByFechaEnvioDesc(Integer idUsuario, Pageable pageable);

    long countByUsuarioIdUsuarioAndLeidoFalse(Integer idUsuario);

    List<Notificaciones> findTop20ByUsuarioIdUsuarioOrderByFechaEnvioDesc(Integer idUsuario);

    @Query("select n from Notificaciones n where n.usuario.idUsuario = :idUsuario and n.leido = false order by n.fechaEnvio desc")
    List<Notificaciones> listarNoLeidas(@Param("idUsuario") Integer idUsuario);
}