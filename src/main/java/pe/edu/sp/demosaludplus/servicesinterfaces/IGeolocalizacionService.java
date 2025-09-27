package pe.edu.sp.demosaludplus.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.Geolocalizacion;

import java.util.List;

public interface IGeolocalizacionService {
    public List<Geolocalizacion>list();
    public void insert(Geolocalizacion geolocalizacion);

    public Geolocalizacion listId(int id);
    public void delete(int id);
    public void update(Geolocalizacion geolocalizacion);
    public List<Geolocalizacion> buscarPorTipo(@Param("tipo") String tipo);
    public List<Object[]> contarPorFecha();
    public int contarUsuariosUnicos();

}
