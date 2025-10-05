package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.sp.demosaludplus.Entities.Medicamentos;

import java.util.List;

@Repository
public interface MedicamentosRepository extends JpaRepository<Medicamentos, Integer> {

    @Query("select m from Medicamentos m where m.citaMedica.id_cita = :idCita")
    List<Medicamentos> listarPorCita(@Param("idCita") Integer idCita);
}