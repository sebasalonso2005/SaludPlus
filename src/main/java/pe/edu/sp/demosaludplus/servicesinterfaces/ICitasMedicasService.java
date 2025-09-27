package pe.edu.sp.demosaludplus.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.CitasMedicas;

import java.util.List;

public interface ICitasMedicasService {
    public List<CitasMedicas> list();

    public void insert(CitasMedicas citasMedicas);

    public CitasMedicas listId(int id);

    public void delete(int id);

    public void update(CitasMedicas citasMedicas);
    public List<CitasMedicas> obtenerCitasMedicasActivas();
    public List<Object[]> cantidadCitasPresencialesPorEstado();
    public List<CitasMedicas> buscarCitasPorIdUsuario(@Param("id_usuario") Integer idUsuario);
    public List<Object[]> cantidadUsuariosConCitaEnFecha(@Param("fecha_cita") java.time.LocalDate fecha_cita);

}
