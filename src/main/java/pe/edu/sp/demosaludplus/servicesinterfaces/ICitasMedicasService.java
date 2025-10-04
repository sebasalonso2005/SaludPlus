package pe.edu.sp.demosaludplus.servicesinterfaces;

import pe.edu.upc.demoSaludPlusNuevo.entities.CitasMedicas;
import java.time.LocalDate;
import java.util.List;

public interface ICitasMedicasService {
    public List<CitasMedicas> list();

    public void insert(CitasMedicas c);

    public CitasMedicas listId(int id);

    public void update(CitasMedicas c);

    public void delete(int id);

    public List<CitasMedicas> listByUsuario(int idUsuario);

    public List<CitasMedicas> searchByUsuarioAndFecha(int idUsuario, LocalDate desde, LocalDate hasta);
}