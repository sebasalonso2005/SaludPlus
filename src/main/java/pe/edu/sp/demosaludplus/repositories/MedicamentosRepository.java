package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demoSaludPlusNuevo.entities.Medicamentos;

import java.util.List;

@Repository
public interface MedicamentosRepository extends JpaRepository<Medicamentos, Integer> {

    @Query("select m from Medicamentos m where m.citaMedica.id_cita = :idCita")
    List<Medicamentos> listarPorCita(@Param("idCita") Integer idCita);
}