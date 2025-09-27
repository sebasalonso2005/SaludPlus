package pe.edu.sp.demosaludplus.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.Usuarios;

import java.util.List;
import java.util.Optional;

public interface IUsuariosService {
    public List<Usuarios>list();
    public void insert(Usuarios usuarios);

    public Usuarios listId(int id);
    public void delete(int id);
    public void update(Usuarios usuarios);
    public Usuarios buscarPorId(@Param("idUsuario") Integer idUsuario);
    public Optional<Usuarios> buscarPorDni(@Param("dni") String dni);
}
