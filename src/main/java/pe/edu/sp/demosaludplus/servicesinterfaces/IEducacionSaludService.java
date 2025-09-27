package pe.edu.sp.demosaludplus.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.EducacionSalud;

import java.time.LocalDate;
import java.util.List;

public interface IEducacionSaludService {
    public List<EducacionSalud>list();
    public void insert(EducacionSalud educacionSalud);

    public EducacionSalud listId(int id);
    public void delete(int id);
    public void update(EducacionSalud educacionSalud);
    public List<EducacionSalud> buscarPorTitulo(@Param("titulo") String titulo);
    public List<EducacionSalud> buscarPorFechaPublicacion(@Param("fechaPublicacion") LocalDate fechaPublicacion);
    public List<Object[]> contarPorTipo(@Param("tipo") String tipo);

}
