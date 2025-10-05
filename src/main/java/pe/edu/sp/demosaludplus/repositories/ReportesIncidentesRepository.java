package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.sp.demosaludplus.Entities.ReportesIncidentes;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReportesIncidentesRepository extends JpaRepository<ReportesIncidentes, Integer> {

    Page<ReportesIncidentes> findByFechaBetween(LocalDate desde, LocalDate hasta, Pageable pageable);

    @Query("select r from ReportesIncidentes r where r.tipoIncidente = :tipo and r.fecha between :desde and :hasta")
    List<ReportesIncidentes> buscarPorTipoYFecha(@Param("tipo") String tipo,
                                                 @Param("desde") LocalDate desde,
                                                 @Param("hasta") LocalDate hasta);
}