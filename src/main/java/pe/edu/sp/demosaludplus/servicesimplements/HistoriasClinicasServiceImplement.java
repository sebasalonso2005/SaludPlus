package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.HistoriasClinicas;
import pe.edu.sp.demosaludplus.Repositories.IHistoriasClinicasRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IHistoriasClinicasService;

import java.util.List;
@Service
public class HistoriasClinicasServiceImplement implements IHistoriasClinicasService {
    @Autowired
    private IHistoriasClinicasRepository hC;
    @Override
    public List<HistoriasClinicas> list() {
        return hC.findAll();
    }

    @Override
    public void insert(HistoriasClinicas historiasClinicas) {
        hC.save(historiasClinicas);
    }

    @Override
    public HistoriasClinicas listId(int id) {
        return hC.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        hC.deleteById(id);
    }

    @Override
    public void update(HistoriasClinicas historiasClinicas) {
        hC.save(historiasClinicas);
    }

    @Override
    public int contarPorEnfermedadCronica(String enfermedad) {
        return hC.contarPorEnfermedadCronica(enfermedad);
    }

    @Override
    public List<HistoriasClinicas> buscarPorDiagnostico(String diagnostico) {
        return hC.buscarPorDiagnostico(diagnostico);
    }

    @Override
    public List<Object[]> contarPorFechaCreacion() {
        return hC.contarPorFechaCreacion();
    }
}
