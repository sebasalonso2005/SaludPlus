package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.sp.demosaludplus.Entities.CitasPresenciales;
import java.util.List;

public interface ICitasPresencialesService {
    public List<CitasPresenciales> list();
    public void insert(CitasPresenciales c);
    public CitasPresenciales listId(int id);
    public void update(CitasPresenciales c);
    public void delete(int id);

    public CitasPresenciales findByCita(int idCita);
}