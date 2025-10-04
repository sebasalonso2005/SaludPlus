package pe.edu.sp.demosaludplus.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.sp.demosaludplus.Entities.Roles;
import pe.edu.sp.demosaludplus.Entities.Usuarios;
import pe.edu.sp.demosaludplus.repositories.RolesRepository;
import pe.edu.sp.demosaludplus.repositories.UsuariosRepository;
import pe.edu.sp.demosaludplus.servicesinterfaces.IUsuariosService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuariosServiceImplement implements IUsuariosService {

    @Autowired
    private UsuariosRepository repository;

    @Autowired
    private RolesRepository rolesRepository; // Para asignar rol por defecto

    @Autowired
    private PasswordEncoder passwordEncoder; // Para encriptar contraseñas

    @Override
    public List<Usuarios> list() {
        return repository.findAll();
    }

    @Override
    public void insert(Usuarios u) {
        // 🔐 Encriptar contraseña antes de guardar
        u.setPassword(passwordEncoder.encode(u.getPassword()));

        // 🛡️ Asignar rol por defecto si no tiene
        if (u.getRoles() == null || u.getRoles().isEmpty()) {
            Roles defaultRole = rolesRepository.findByNombre("USER")
                    .orElseThrow(() -> new RuntimeException("Rol 'USER' no encontrado"));
            Set<Roles> roles = new HashSet<>();
            roles.add(defaultRole);
            u.setRoles(roles);
        }

        repository.save(u);
    }

    @Override
    public Usuarios listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Usuarios u) {
        // 🔐 Si la contraseña fue modificada, encriptarla de nuevo
        Usuarios existingUser = repository.findById(u.getIdUsuario()).orElse(null);
        if (existingUser != null && !existingUser.getPassword().equals(u.getPassword())) {
            u.setPassword(passwordEncoder.encode(u.getPassword()));
        }
        repository.save(u);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Usuarios> searchByComunidad(String comunidad) {
        return repository.findByComunidadIgnoreCase(comunidad, Pageable.unpaged())
                .getContent()
                .stream()
                .collect(Collectors.toList());
    }
}
