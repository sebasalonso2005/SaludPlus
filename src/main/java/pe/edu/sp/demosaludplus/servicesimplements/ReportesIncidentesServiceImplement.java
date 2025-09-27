package pe.edu.sp.demosaludplus.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.sp.demosaludplus.Entities.ReportesIncidentes;
import pe.edu.sp.demosaludplus.Repositories.IReportesIncidentesRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IReportesIncidentesService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ReportesIncidentesServiceImplement implements IReportesIncidentesService {
    @Autowired
    private IReportesIncidentesRepository rI;
    @Override
    public List<ReportesIncidentes> list() {
        return rI.findAll();
    }

    @Override
    public void insert(ReportesIncidentes reportesIncidentes) {
        rI.save(reportesIncidentes);
    }

    @Override
    public ReportesIncidentes list(int idReporte) {
        return rI.findById(idReporte).orElse(null);
    }

    @Override
    public void delete(int idReporte) {
        rI.deleteById(idReporte);
    }

    @Override
    public void update(ReportesIncidentes reportesIncidentes) {
        rI.save(reportesIncidentes);
    }

    @Override
    public List<ReportesIncidentes> buscarBigDataReportes(String nReportes) { //PREGUNTAR 
        return List.of();
    }

    @Override
    public List<ReportesIncidentes> buscarPorFecha(LocalDate fecha) {
        return rI.buscarPorFecha(fecha);
    }

    @Override
    public List<Object[]> cantidadIncidentesPorLugar() {
        return rI.cantidadIncidentesPorLugar();
    }


}


