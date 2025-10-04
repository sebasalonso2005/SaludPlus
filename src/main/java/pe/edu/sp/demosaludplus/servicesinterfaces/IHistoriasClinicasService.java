package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.sp.demosaludplus.Entities.HistoriasClinicas;
import java.util.List;

public interface IHistoriasClinicasService {
    public List<HistoriasClinicas> list();
    public void insert(HistoriasClinicas h);
    public HistoriasClinicas listId(int id);
    public void update(HistoriasClinicas h);
    public void delete(int id);

    public HistoriasClinicas findByCita(int idCita);
}