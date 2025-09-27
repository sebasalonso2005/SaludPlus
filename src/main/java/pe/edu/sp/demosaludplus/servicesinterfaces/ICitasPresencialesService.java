package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.sp.demosaludplus.Entities.CitasPresenciales;

import java.util.List;

public interface ICitasPresencialesService {
    public List<CitasPresenciales> list();

    public void insert(CitasPresenciales citasPresenciales);

    public CitasPresenciales listId(int id);

    public void delete(int id);

    public void update(CitasPresenciales citasPresenciales);
    public List<Object[]> mostrarEstadoDeCitas();
    public List<Object[]> cantidadCitasPresencialesPorEstado();
    public List<Object[]> cantidadMedicosPorConsultorio();
    public List<Object[]> cantidadCitasPorConsultorio();
    public List<Object[]> cantidadCitasPorMedicoAsignado();

}
