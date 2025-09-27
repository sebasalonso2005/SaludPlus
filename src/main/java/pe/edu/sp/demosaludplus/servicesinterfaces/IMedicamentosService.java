package pe.edu.sp.demosaludplus.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.Medicamentos;

import java.util.List;

public interface IMedicamentosService {
    public List<Medicamentos>list();
    public void insert(Medicamentos medicamentos);

    public Medicamentos listId(int id);
    public void delete(int id);
    public void update(Medicamentos medicamentos);
    public List<Medicamentos> buscarPorNombre(@Param("nombre") String nombre);
    public List<Medicamentos> buscarPorDosis(@Param("dosis") String dosis);
    public List<Object[]> contarMedicamentosPorDuracion();

}
