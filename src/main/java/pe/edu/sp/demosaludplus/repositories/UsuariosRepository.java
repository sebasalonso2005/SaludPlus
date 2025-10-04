package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.sp.demosaludplus.Entities.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    Optional<Usuarios> findByUsername(String username);
    Optional<Usuarios> findByCorreo(String correo);
    Optional<Usuarios> findByDni(String dni);

    boolean existsByUsername(String username);
    boolean existsByCorreo(String correo);
    boolean existsByDni(String dni);

    Page<Usuarios> findByComunidadIgnoreCase(String comunidad, Pageable pageable);

    @Query("select distinct u from Usuarios u left join fetch u.roles where u.username = :username")
    Optional<Usuarios> findByUsernameConRoles(String username);

    @Query("select distinct u from Usuarios u left join fetch u.roles where u.idUsuario = :idUsuario")
    Optional<Usuarios> findByIdConRoles(Integer idUsuario);
}
