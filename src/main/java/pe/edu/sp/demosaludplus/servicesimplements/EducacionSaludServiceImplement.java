package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.EducacionSalud;
import pe.edu.upc.demoSaludPlusNuevo.repositories.EducacionSaludRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IEducacionSaludService;


import java.time.LocalDate;
import java.util.List;

@Service
public class EducacionSaludServiceImplement implements IEducacionSaludService {

    @Autowired
    private EducacionSaludRepository repository;

    @Override
    public List<EducacionSalud> list() { return repository.findAll(); }

    @Override
    public void insert(EducacionSalud e) { repository.save(e); }

    @Override
    public EducacionSalud listId(int id) { return repository.findById(id).orElse(null); }

    @Override
    public void update(EducacionSalud e) { repository.save(e); }

    @Override
    public void delete(int id) { repository.deleteById(id); }

    @Override
    public List<EducacionSalud> searchTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo, Pageable.unpaged()).getContent();
    }

    @Override
    public List<EducacionSalud> listByTipo(int tipo) {
        return repository.findByTipo(tipo, Pageable.unpaged()).getContent();
    }

    @Override
    public List<EducacionSalud> searchByFecha(LocalDate desde, LocalDate hasta) {
        return repository.findByFechaPublicacionBetween(desde, hasta, Pageable.unpaged()).getContent();
    }
}
