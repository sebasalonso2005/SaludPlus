package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.ExamenesMedicos;
import pe.edu.sp.demosaludplus.repositories.ExamenesMedicosRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IExamenesMedicosService;

import java.util.List;

@Service
public class ExamenesMedicosServiceImplement implements IExamenesMedicosService {

    @Autowired
    private ExamenesMedicosRepository repository;

    @Override
    public List<ExamenesMedicos> list() { return repository.findAll(); }

    @Override
    public void insert(ExamenesMedicos e) { repository.save(e); }

    @Override
    public ExamenesMedicos listId(int id) { return repository.findById(id).orElse(null); }

    @Override
    public void update(ExamenesMedicos e) { repository.save(e); }

    @Override
    public void delete(int id) { repository.deleteById(id); }

    @Override
    public List<ExamenesMedicos> listByCita(int idCita) {
        return repository.listarPorCita(idCita);
    }
}
