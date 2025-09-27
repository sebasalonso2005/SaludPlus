package pe.edu.sp.demosaludplus.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.sp.demosaludplus.Entities.ReportesIncidentes;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReportesIncidentesRepository extends JpaRepository<ReportesIncidentes, Integer> {
    // en este query buscas por la fecha y te mostraran todos los incidentes registrados esa fecha
    @Query("select r from ReportesIncidentes r where r.fecha = :fecha")
    public List<ReportesIncidentes> buscarPorFecha(@Param("fecha") LocalDate fecha);

    // te dara la cantidad de incidentes que hubo por el lugar
    @Query(value = "select r.lugarIncidente, count(r.id_reporte)\n" +
            "from ReportesIncidentes r\n" +
            "group by r.lugarIncidente", nativeQuery = true)
    public List<Object[]> cantidadIncidentesPorLugar();

}
