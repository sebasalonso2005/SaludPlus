package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.CitasMedicas;
import pe.edu.sp.demosaludplus.Repositories.ICitasMedicasRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.ICitasMedicasService;

import java.time.LocalDate;
import java.util.List;
@Service
public class CitasMedicasServiceImplement implements ICitasMedicasService {
    @Autowired
    private ICitasMedicasRepository cM;
    @Override
    public List<CitasMedicas> list() {

        return (List<CitasMedicas>) cM.findAll();
    }

    @Override
    public void insert(CitasMedicas citasMedicas) {
        cM.save(citasMedicas);
    }

    @Override
    public CitasMedicas listId(int id) {

        return cM.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        cM.deleteById(id);
    }

    @Override
    public void update(CitasMedicas citasMedicas) {
        cM.save(citasMedicas);
    }

    @Override
    public List<CitasMedicas> obtenerCitasMedicasActivas() {
        return cM.obtenerCitasMedicasActivas();
    }

    @Override
    public List<Object[]> cantidadCitasPresencialesPorEstado() {
        return cM.cantidadCitasPresencialesPorEstado();
    }

    @Override
    public List<CitasMedicas> buscarCitasPorIdUsuario(Integer idUsuario) {
        return cM.buscarCitasPorIdUsuario(idUsuario);
    }

    @Override
    public List<Object[]> cantidadUsuariosConCitaEnFecha(LocalDate fecha_cita) {
        return cM.cantidadUsuariosConCitaEnFecha(fecha_cita);
    }
}
