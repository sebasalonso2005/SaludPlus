package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.ReportesIncidentes;

import java.time.*;
import java.util.*;

@Repository
public interface ReportesIncidentesRepository extends JpaRepository<ReportesIncidentes, Integer> {

    Page<ReportesIncidentes> findByFechaBetween(LocalDate desde, LocalDate hasta, Pageable pageable);

    @Query("select r from ReportesIncidentes r where r.tipoIncidente = :tipo and r.fecha between :desde and :hasta")
    List<ReportesIncidentes> buscarPorTipoYFecha(@Param("tipo") String tipo,
                                                 @Param("desde") LocalDate desde,
                                                 @Param("hasta") LocalDate hasta);
}