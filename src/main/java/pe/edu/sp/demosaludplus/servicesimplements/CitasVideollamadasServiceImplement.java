package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.CitasVideollamadas;
import pe.edu.sp.demosaludplus.Repositories.ICitasVideollamadasRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.ICitasVideollamadasService;

import java.util.List;
@Service
public class CitasVideollamadasServiceImplement implements ICitasVideollamadasService {
    @Autowired
    private ICitasVideollamadasRepository cV;
    @Override
    public List<CitasVideollamadas> list() {
        return cV.findAll();
    }

    @Override
    public void insert(CitasVideollamadas citasVideollamadas) {
        cV.save(citasVideollamadas);
    }

    @Override
    public CitasVideollamadas listId(int id) {
        return cV.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        cV.deleteById(id);
    }

    @Override
    public void update(CitasVideollamadas citasVideollamadas) {
        cV.save(citasVideollamadas);
    }

    @Override
    public List<CitasVideollamadas> buscarCitasPorEstado(String estado) {
        return cV.buscarCitasPorEstado(estado);
    }

    @Override
    public List<Object[]> obtenerEstadoYPlataformaDeCitasVideoLlamadas() {
        return cV.obtenerEstadoYPlataformaDeCitasVideoLlamadas();
    }

    @Override
    public List<Object[]> mostrarEstadoDeCitasVideoLlamadas() {
        return cV.mostrarEstadoDeCitasVideoLlamadas();
    }

    @Override
    public List<Object[]> cantidadCitasVideollamadasPorEstado() {
        return cV.cantidadCitasVideollamadasPorEstado();
    }
}
