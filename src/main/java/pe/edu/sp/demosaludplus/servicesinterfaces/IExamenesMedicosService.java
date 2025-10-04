package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.upc.demoSaludPlusNuevo.entities.ExamenesMedicos;
import java.util.List;

public interface IExamenesMedicosService {
    public List<ExamenesMedicos> list();

    public void insert(ExamenesMedicos e);

    public ExamenesMedicos listId(int id);

    public void update(ExamenesMedicos e);

    public void delete(int id);

    public List<ExamenesMedicos> listByCita(int idCita);
}