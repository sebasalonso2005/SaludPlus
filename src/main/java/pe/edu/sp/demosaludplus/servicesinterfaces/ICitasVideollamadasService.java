package pe.edu.sp.demosaludplus.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.CitasVideollamadas;

import java.util.List;

public interface ICitasVideollamadasService {
    public List<CitasVideollamadas>list();
    public void insert(CitasVideollamadas citasVideollamadas);

    public CitasVideollamadas listId(int id);
    public void delete(int id);
    public void update(CitasVideollamadas citasVideollamadas);
    public List<CitasVideollamadas> buscarCitasPorEstado(@Param("estado") String estado);
    public List<Object[]> obtenerEstadoYPlataformaDeCitasVideoLlamadas();
    public List<Object[]> mostrarEstadoDeCitasVideoLlamadas();
    public List<Object[]> cantidadCitasVideollamadasPorEstado();

}
