package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.CitasPresenciales;
import pe.edu.sp.demosaludplus.Repositories.ICitasPresencialesRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.ICitasPresencialesService;

import java.util.List;
@Service
public class CitasPresencialesServiceImplement implements ICitasPresencialesService {
    @Autowired
    private ICitasPresencialesRepository cP;
    @Override
    public List<CitasPresenciales> list() {
        return (List<CitasPresenciales>) cP.findAll();
    }

    @Override
    public void insert(CitasPresenciales citasPresenciales) {
        cP.save(citasPresenciales);
    }

    @Override
    public CitasPresenciales listId(int id) {
        return cP.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        cP.deleteById(id);
    }

    @Override
    public void update(CitasPresenciales citasPresenciales) {
        cP.save(citasPresenciales);
    }

    @Override
    public List<Object[]> mostrarEstadoDeCitas() {
        return cP.mostrarEstadoDeCitas();
    }

    @Override
    public List<Object[]> cantidadCitasPresencialesPorEstado() {
        return cP.cantidadCitasPresencialesPorEstado();
    }

    @Override
    public List<Object[]> cantidadMedicosPorConsultorio() {
        return cP.cantidadMedicosPorConsultorio();
    }

    @Override
    public List<Object[]> cantidadCitasPorConsultorio() {
        return cP.cantidadCitasPorConsultorio();
    }

    @Override
    public List<Object[]> cantidadCitasPorMedicoAsignado() {
        return cP.cantidadCitasPorMedicoAsignado();
    }
}
