package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.sp.demosaludplus.Entities.ReportesIncidentes;

import java.time.LocalDate;
import java.util.List;

public interface IReportesIncidentesService {
    public List<ReportesIncidentes> list();
    public void insert(ReportesIncidentes r);
    public ReportesIncidentes listId(int id);
    public void update(ReportesIncidentes r);
    public void delete(int id);

    public List<ReportesIncidentes> searchByTipoYFecha(String tipo, LocalDate desde, LocalDate hasta);
}