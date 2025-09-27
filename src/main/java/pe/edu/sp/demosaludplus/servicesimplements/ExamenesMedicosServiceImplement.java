package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.ExamenesMedicos;
import pe.edu.sp.demosaludplus.Repositories.IExamenesMedicosRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IExamenesMedicosService;

import java.time.LocalDate;
import java.util.List;
@Service
public class ExamenesMedicosServiceImplement implements IExamenesMedicosService {
    @Autowired
    private IExamenesMedicosRepository eM;
    @Override
    public List<ExamenesMedicos> list() {
        return eM.findAll();
    }

    @Override
    public void insert(ExamenesMedicos examenesMedicos) {
        eM.save(examenesMedicos);
    }

    @Override
    public ExamenesMedicos listId(int id) {
        return eM.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        eM.deleteById(id);
    }

    @Override
    public void update(ExamenesMedicos examenesMedicos) {
        eM.save(examenesMedicos);
    }

    @Override
    public List<ExamenesMedicos> buscarPorTipo(String tipoExamen) {
        return eM.buscarPorTipo(tipoExamen);
    }

    @Override
    public List<Object[]> contarPorFecha(LocalDate fecha) {
        return eM.contarPorFecha(fecha);
    }

    @Override
    public List<Object[]> contarExamenesPorTipo() {
        return eM.contarExamenesPorTipo();
    }

    @Override
    public List<Object[]> contarExamenesPorArchivoUrl() {
        return eM.contarExamenesPorArchivoUrl();
    }
}
