package pe.edu.upc.demoSaludPlusNuevo.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demoSaludPlusNuevo.entities.EventosPeligrosos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.time.LocalDateTime;
import java.util.*;

@Repository
public interface EventosPeligrososRepository extends JpaRepository<EventosPeligrosos, Integer> {

    Page<EventosPeligrosos> findByUsuarioIdUsuario(Integer idUsuario, Pageable pageable);

    @Query("select e from EventosPeligrosos e where e.usuario.idUsuario = :idUsuario and e.fecha between :desde and :hasta order by e.fecha desc")
    List<EventosPeligrosos> buscarPorUsuarioYFecha(@Param("idUsuario") Integer idUsuario,
                                                   @Param("desde") LocalDateTime desde,
                                                   @Param("hasta") LocalDateTime hasta);

    List<EventosPeligrosos> findByTipoIgnoreCase(String tipo);
}