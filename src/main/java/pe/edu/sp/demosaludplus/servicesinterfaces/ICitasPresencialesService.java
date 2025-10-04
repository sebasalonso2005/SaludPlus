package pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces;

import pe.edu.upc.demoSaludPlusNuevo.entities.CitasPresenciales;
import java.util.List;

public interface ICitasPresencialesService {
    public List<CitasPresenciales> list();
    public void insert(CitasPresenciales c);
    public CitasPresenciales listId(int id);
    public void update(CitasPresenciales c);
    public void delete(int id);

    public CitasPresenciales findByCita(int idCita);
}