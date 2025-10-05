package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.sp.demosaludplus.Entities.CitasMedicas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitasMedicasRepository extends JpaRepository<CitasMedicas, Integer> {

    @Query("select c from CitasMedicas c where c.usuario.idUsuario = :idUsuario order by c.fecha_cita desc, c.hora desc")
    List<CitasMedicas> listarPorUsuario(@Param("idUsuario") Integer idUsuario);

    @Query("select c from CitasMedicas c where c.usuario.idUsuario = :idUsuario and c.fecha_cita between :desde and :hasta order by c.fecha_cita asc, c.hora asc")
    List<CitasMedicas> buscarPorUsuarioYFecha(@Param("idUsuario") Integer idUsuario,
                                              @Param("desde") LocalDate desde,
                                              @Param("hasta") LocalDate hasta);

    Page<CitasMedicas> findByEstadoIgnoreCase(String estado, Pageable pageable);

    Page<CitasMedicas> findByTipoIgnoreCase(String tipo, Pageable pageable);

    Page<CitasMedicas> findByCreadaEnBetween(LocalDateTime desde, LocalDateTime hasta, Pageable pageable);

    @Query("select c from CitasMedicas c where c.usuario.idUsuario = :idUsuario and c.estado = :estado")
    Page<CitasMedicas> buscarPorUsuarioYEstado(@Param("idUsuario") Integer idUsuario,
                                               @Param("estado") String estado,
                                               Pageable pageable);
}