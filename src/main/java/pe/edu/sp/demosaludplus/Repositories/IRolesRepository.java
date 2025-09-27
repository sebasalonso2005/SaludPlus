package pe.edu.sp.demosaludplus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.Roles;

import java.util.List;

public interface IRolesRepository extends JpaRepository<Roles, Integer> {
    //este query busca el rol y te da la cantidad de usuarios que esten en este rol
    @Query("select count(u) from Roles r join r.usuarios u where r.nombre = :rol")
    public int contarUsuariosPorRol(@Param("rol") String rol);
}
