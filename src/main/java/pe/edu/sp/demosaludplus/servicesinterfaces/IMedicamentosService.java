package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.upc.demoSaludPlusNuevo.entities.Medicamentos;
import java.util.List;

public interface IMedicamentosService {
    public List<Medicamentos> list();
    public void insert(Medicamentos m);
    public Medicamentos listId(int id);
    public void update(Medicamentos m);
    public void delete(int id);

    public List<Medicamentos> listByCita(int idCita);
}