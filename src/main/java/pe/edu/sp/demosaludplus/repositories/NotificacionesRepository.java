package pe.edu.upc.demoSaludPlusNuevo.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demoSaludPlusNuevo.entities.Notificaciones;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.*;

@Repository
public interface NotificacionesRepository extends JpaRepository<Notificaciones, Integer> {

    Page<Notificaciones> findByUsuarioIdUsuarioOrderByFechaEnvioDesc(Integer idUsuario, Pageable pageable);

    long countByUsuarioIdUsuarioAndLeidoFalse(Integer idUsuario);

    List<Notificaciones> findTop20ByUsuarioIdUsuarioOrderByFechaEnvioDesc(Integer idUsuario);

    @Query("select n from Notificaciones n where n.usuario.idUsuario = :idUsuario and n.leido = false order by n.fechaEnvio desc")
    List<Notificaciones> listarNoLeidas(@Param("idUsuario") Integer idUsuario);
}