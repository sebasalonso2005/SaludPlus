package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.sp.demosaludplus.Entities.EducacionSalud;

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