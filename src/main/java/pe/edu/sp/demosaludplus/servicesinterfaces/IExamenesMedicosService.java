package pe.edu.sp.demosaludplus.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.ExamenesMedicos;

import java.time.LocalDate;
import java.util.List;

public interface IExamenesMedicosService {
    public List<ExamenesMedicos>list();
    public void insert(ExamenesMedicos examenesMedicos);

    public ExamenesMedicos listId(int id);
    public void delete(int id);
    public void update(ExamenesMedicos examenesMedicos);
    public List<ExamenesMedicos> buscarPorTipo(@Param("tipoExamen") String tipoExamen);
    public List<Object[]> contarPorFecha(@Param("fecha") LocalDate fecha);
    public List<Object[]> contarExamenesPorTipo();
    public List<Object[]> contarExamenesPorArchivoUrl();

}
