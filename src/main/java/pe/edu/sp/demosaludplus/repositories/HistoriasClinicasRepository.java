package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demoSaludPlusNuevo.entities.HistoriasClinicas;

import java.util.Optional;

@Repository
public interface HistoriasClinicasRepository extends JpaRepository<HistoriasClinicas, Integer> {

    @Query("select h from HistoriasClinicas h where h.citaMedica.id_cita = :idCita")
    Optional<HistoriasClinicas> findByIdCita(@Param("idCita") Integer idCita);
}