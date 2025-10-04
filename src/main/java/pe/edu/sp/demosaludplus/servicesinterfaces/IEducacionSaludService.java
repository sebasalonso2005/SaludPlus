package pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces;

import pe.edu.upc.demoSaludPlusNuevo.entities.EducacionSalud;
import java.time.LocalDate;
import java.util.List;

public interface IEducacionSaludService {
    public List<EducacionSalud> list();
    public void insert(EducacionSalud e);
    public EducacionSalud listId(int id);
    public void update(EducacionSalud e);
    public void delete(int id);

    public List<EducacionSalud> searchTitulo(String titulo);
    public List<EducacionSalud> listByTipo(int tipo);
    public List<EducacionSalud> searchByFecha(LocalDate desde, LocalDate hasta);
}