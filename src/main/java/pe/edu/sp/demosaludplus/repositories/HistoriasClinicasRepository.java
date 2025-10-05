package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.sp.demosaludplus.Entities.HistoriasClinicas;

import java.util.Optional;

@Repository
public interface HistoriasClinicasRepository extends JpaRepository<HistoriasClinicas, Integer> {

    @Query("select h from HistoriasClinicas h where h.citaMedica.id_cita = :idCita")
    Optional<HistoriasClinicas> findByIdCita(@Param("idCita") Integer idCita);
}