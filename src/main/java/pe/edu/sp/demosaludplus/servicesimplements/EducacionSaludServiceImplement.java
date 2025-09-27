package pe.edu.sp.demosaludplus.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.EducacionSalud;
import pe.edu.sp.demosaludplus.Repositories.IEducacionSaludRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IEducacionSaludService;

import java.time.LocalDate;
import java.util.List;
@Service
public class EducacionSaludServiceImplement implements IEducacionSaludService {
    @Autowired
    private IEducacionSaludRepository repository;
    @Override
    public List<EducacionSalud> list() {

        return this.repository.findAll();
    }
    @Override
    public void insert(EducacionSalud educacionSalud) {

        this.repository.save(educacionSalud);
    }

    @Override
    public EducacionSalud listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public void update(EducacionSalud educacionSalud) {
        this.repository.save(educacionSalud);
    }

    @Override
    public List<EducacionSalud> buscarPorTitulo(String titulo) {
        return repository.buscarPorTitulo(titulo);
    }

    @Override
    public List<EducacionSalud> buscarPorFechaPublicacion(LocalDate fechaPublicacion) {
        return repository.buscarPorFechaPublicacion(fechaPublicacion);
    }

    @Override
    public List<Object[]> contarPorTipo(String tipo) {
        return repository.contarPorTipo(tipo);
    }
}
