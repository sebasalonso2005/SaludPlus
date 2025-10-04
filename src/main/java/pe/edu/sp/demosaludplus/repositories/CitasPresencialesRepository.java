package pe.edu.upc.demoSaludPlusNuevo.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demoSaludPlusNuevo.entities.CitasPresenciales;

import java.util.Optional;

@Repository
public interface CitasPresencialesRepository extends JpaRepository<CitasPresenciales, Integer> {

    @Query("select cp from CitasPresenciales cp where cp.citaMedica.id_cita = :idCita")
    Optional<CitasPresenciales> findByIdCita(@Param("idCita") Integer idCita);
}