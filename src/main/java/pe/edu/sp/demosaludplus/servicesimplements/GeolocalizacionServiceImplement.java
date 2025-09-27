package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.Geolocalizacion;
import pe.edu.sp.demosaludplus.Repositories.IGeolocalizacionRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IGeolocalizacionService;

import java.util.List;
@Service
public class GeolocalizacionServiceImplement implements IGeolocalizacionService {
    @Autowired
    private IGeolocalizacionRepository gG;
    @Override
    public List<Geolocalizacion> list() {
        return gG.findAll();
    }

    @Override
    public void insert(Geolocalizacion geolocalizacion) {
        gG.save(geolocalizacion);
    }

    @Override
    public Geolocalizacion listId(int id) {
        return gG.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        gG.deleteById(id);
    }

    @Override
    public void update(Geolocalizacion geolocalizacion) {
        gG.save(geolocalizacion);
    }

    @Override
    public List<Geolocalizacion> buscarPorTipo(String tipo) {
        return gG.buscarPorTipo(tipo);
    }

    @Override
    public List<Object[]> contarPorFecha() {
        return gG.contarPorFecha();
    }

    @Override
    public int contarUsuariosUnicos() {
        return gG.contarUsuariosUnicos();
    }
}
