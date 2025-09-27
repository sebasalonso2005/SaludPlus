package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.Usuarios;
import pe.edu.sp.demosaludplus.Repositories.IUsuariosRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IUsuariosService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImplement implements IUsuariosService {
    @Autowired
    private IUsuariosRepository uU;
    @Override
    public List<Usuarios> list() {
        return uU.findAll();
    }

    @Override
    public void insert(Usuarios usuarios) {
        uU.save(usuarios);
    }

    @Override
    public Usuarios listId(int id) {
        return uU.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        uU.deleteById(id);
    }

    @Override
    public void update(Usuarios usuarios) {
        uU.save(usuarios);
    }

    @Override
    public Usuarios buscarPorId(Integer idUsuario) {
        return uU.buscarPorId(idUsuario);
    }

    @Override
    public Optional<Usuarios> buscarPorDni(String dni) {
        return uU.buscarPorDni(dni);
    }
}
