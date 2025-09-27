package pe.edu.sp.demosaludplus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.Usuarios;

import java.util.Optional;
import java.util.List;

public interface IUsuariosRepository extends JpaRepository<Usuarios, Integer> {
   // este query busca al usuario por id
    @Query("select u from Usuarios u where u.idUsuario = :idUsuario")
    public Usuarios buscarPorId(@Param("idUsuario") Integer idUsuario);

    // este query busca al usuario por el dni ingresado
    @Query("select u from Usuarios u where u.dni = :dni")
    public Optional<Usuarios> buscarPorDni(@Param("dni") String dni);
}
