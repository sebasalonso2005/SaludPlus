package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.Medicamentos;
import pe.edu.sp.demosaludplus.Repositories.IMedicamentosRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IMedicamentosService;

import java.util.List;
@Service
public class MedicamentosServiceImplement implements IMedicamentosService {
    @Autowired
    private IMedicamentosRepository mM;
    @Override
    public List<Medicamentos> list() {
        return mM.findAll();
    }

    @Override
    public void insert(Medicamentos medicamentos) {
        mM.save(medicamentos);
    }

    @Override
    public Medicamentos listId(int id) {
        return mM.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        mM.deleteById(id);
    }

    @Override
    public void update(Medicamentos medicamentos) {
        mM.save(medicamentos);
    }

    @Override
    public List<Medicamentos> buscarPorNombre(String nombre) {
        return mM.buscarPorNombre(nombre);
    }

    @Override
    public List<Medicamentos> buscarPorDosis(String dosis) {
        return mM.buscarPorDosis(dosis);
    }

    @Override
    public List<Object[]> contarMedicamentosPorDuracion() {
        return mM.contarMedicamentosPorDuracion();
    }
}
