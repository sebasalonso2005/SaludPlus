package pe.edu.sp.demosaludplus.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.HistoriasClinicas;

import java.util.List;

public interface IHistoriasClinicasService {
    public List<HistoriasClinicas>list();
    public void insert(HistoriasClinicas historiasClinicas);

    public HistoriasClinicas listId(int id);
    public void delete(int id);
    public void update(HistoriasClinicas historiasClinicas);
    public int contarPorEnfermedadCronica(@Param("enfermedad") String enfermedad);
    public List<HistoriasClinicas> buscarPorDiagnostico(@Param("diagnostico") String diagnostico);
    public List<Object[]> contarPorFechaCreacion();

}
