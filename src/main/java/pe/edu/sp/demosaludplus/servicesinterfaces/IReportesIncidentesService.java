package pe.edu.sp.demosaludplus.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.ReportesIncidentes;

import java.time.LocalDate;
import java.util.List;


public interface IReportesIncidentesService {
    public List<ReportesIncidentes> list();
    public void insert(ReportesIncidentes reportesIncidentes);

    public ReportesIncidentes list(int idReporte);
    public void delete(int idReporte);
    public void update(ReportesIncidentes reportesIncidentes);
    public List<ReportesIncidentes> buscarBigDataReportes(String nReportes);
    public List<ReportesIncidentes> buscarPorFecha(@Param("fecha") LocalDate fecha);
    public List<Object[]> cantidadIncidentesPorLugar();

}
