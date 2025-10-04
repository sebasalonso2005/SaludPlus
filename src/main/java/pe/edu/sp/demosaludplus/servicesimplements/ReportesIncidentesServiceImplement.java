package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoSaludPlusNuevo.entities.ReportesIncidentes;
import pe.edu.upc.demoSaludPlusNuevo.repositories.ReportesIncidentesRepository;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.IReportesIncidentesService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportesIncidentesServiceImplement implements IReportesIncidentesService {

    @Autowired
    private ReportesIncidentesRepository repository;

    @Override
    public List<ReportesIncidentes> list() { return repository.findAll(); }

    @Override
    public void insert(ReportesIncidentes r) { repository.save(r); }

    @Override
    public ReportesIncidentes listId(int id) { return repository.findById(id).orElse(null); }

    @Override
    public void update(ReportesIncidentes r) { repository.save(r); }

    @Override
    public void delete(int id) { repository.deleteById(id); }

    @Override
    public List<ReportesIncidentes> searchByTipoYFecha(String tipo, LocalDate desde, LocalDate hasta) {
        return repository.buscarPorTipoYFecha(tipo, desde, hasta);
    }
}