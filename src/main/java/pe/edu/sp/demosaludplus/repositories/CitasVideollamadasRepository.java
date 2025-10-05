package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.CitasVideollamadas;

import java.util.Optional;

@Repository
public interface CitasVideollamadasRepository extends JpaRepository<CitasVideollamadas, Integer> {

    @Query("select cv from CitasVideollamadas cv where cv.citaMedica.id_cita = :idCita")
    Optional<CitasVideollamadas> findByIdCita(@Param("idCita") Integer idCita);
}