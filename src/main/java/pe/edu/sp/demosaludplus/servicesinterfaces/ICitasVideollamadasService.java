package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.sp.demosaludplus.Entities.CitasVideollamadas;
import java.util.List;

public interface ICitasVideollamadasService {
    public List<CitasVideollamadas> list();
    public void insert(CitasVideollamadas c);
    public CitasVideollamadas listId(int id);
    public void update(CitasVideollamadas c);
    public void delete(int id);

    public CitasVideollamadas findByCita(int idCita);
}