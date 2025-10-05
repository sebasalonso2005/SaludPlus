package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.sp.demosaludplus.Entities.EventosPeligrosos;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventosPeligrososRepository extends JpaRepository<EventosPeligrosos, Integer> {

    Page<EventosPeligrosos> findByUsuarioIdUsuario(Integer idUsuario, Pageable pageable);

    @Query("select e from EventosPeligrosos e where e.usuario.idUsuario = :idUsuario and e.fecha between :desde and :hasta order by e.fecha desc")
    List<EventosPeligrosos> buscarPorUsuarioYFecha(@Param("idUsuario") Integer idUsuario,
                                                   @Param("desde") LocalDateTime desde,
                                                   @Param("hasta") LocalDateTime hasta);

    List<EventosPeligrosos> findByTipoIgnoreCase(String tipo);
}