package pe.edu.upc.demoSaludPlusNuevo.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demoSaludPlusNuevo.entities.Geolocalizacion;

import java.util.Optional;

@Repository
public interface GeolocalizacionRepository extends JpaRepository<Geolocalizacion, Integer> {

    Optional<Geolocalizacion> findByUsuarioIdUsuario(Integer idUsuario);

    @Query("select g from Geolocalizacion g where g.usuario.idUsuario = :idUsuario")
    Optional<Geolocalizacion> buscarPorUsuario(@Param("idUsuario") Integer idUsuario);
}