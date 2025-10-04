package pe.edu.upc.demoSaludPlusNuevo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoSaludPlusNuevo.entities.Geolocalizacion;
import pe.edu.upc.demoSaludPlusNuevo.repositories.GeolocalizacionRepository;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.IGeolocalizacionService;

import java.util.List;

@Service
public class GeolocalizacionServiceImplement implements IGeolocalizacionService {

    @Autowired
    private GeolocalizacionRepository repository;

    @Override
    public List<Geolocalizacion> list() { return repository.findAll(); }

    @Override
    public void insert(Geolocalizacion g) { repository.save(g); }

    @Override
    public Geolocalizacion listId(int id) { return repository.findById(id).orElse(null); }

    @Override
    public void update(Geolocalizacion g) { repository.save(g); }

    @Override
    public void delete(int id) { repository.deleteById(id); }

    @Override
    public Geolocalizacion findByUsuario(int idUsuario) {
        return repository.findByUsuarioIdUsuario(idUsuario).orElse(null);
    }
}