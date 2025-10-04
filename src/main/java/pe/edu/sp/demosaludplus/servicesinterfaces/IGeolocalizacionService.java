package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.sp.demosaludplus.Entities.Geolocalizacion;
import java.util.List;

public interface IGeolocalizacionService {
    public List<Geolocalizacion> list();
    public void insert(Geolocalizacion g);
    public Geolocalizacion listId(int id);
    public void update(Geolocalizacion g);
    public void delete(int id);

    public Geolocalizacion findByUsuario(int idUsuario);
}