package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.Geolocalizacion;
import pe.edu.sp.demosaludplus.repositories.GeolocalizacionRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IGeolocalizacionService;

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