package pe.edu.sp.demosaludplus.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.servicesinterfaces.ICitasMedicasService;
import pe.edu.upc.demoSaludPlusNuevo.entities.CitasMedicas;
import pe.edu.upc.demoSaludPlusNuevo.repositories.CitasMedicasRepository;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.ICitasMedicasService;

import java.time.LocalDate;
import java.util.List;

@Service
public class CitasMedicasServiceImplement implements ICitasMedicasService {

    @Autowired
    private CitasMedicasRepository repository;

    @Override
    public List<CitasMedicas> list() { return repository.findAll(); }

    @Override
    public void insert(CitasMedicas c) { repository.save(c); }

    @Override
    public CitasMedicas listId(int id) { return repository.findById(id).orElse(null); }

    @Override
    public void update(CitasMedicas c) { repository.save(c); }

    @Override
    public void delete(int id) { repository.deleteById(id); }

    @Override
    public List<CitasMedicas> listByUsuario(int idUsuario) {
        return repository.listarPorUsuario(idUsuario);
    }

    @Override
    public List<CitasMedicas> searchByUsuarioAndFecha(int idUsuario, LocalDate desde, LocalDate hasta) {
        return repository.buscarPorUsuarioYFecha(idUsuario, desde, hasta);
    }
}