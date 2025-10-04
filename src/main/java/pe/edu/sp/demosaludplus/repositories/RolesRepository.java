package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoSaludPlusNuevo.entities.Roles;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByNombre(String nombre);
    List<Roles> findByNombreIn(Collection<String> nombres);
}
