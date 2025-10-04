package pe.edu.upc.demoSaludPlusNuevo.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demoSaludPlusNuevo.entities.ExamenesMedicos;

import java.util.List;

@Repository
public interface ExamenesMedicosRepository extends JpaRepository<ExamenesMedicos, Integer> {

    @Query("select e from ExamenesMedicos e where e.citaMedica.id_cita = :idCita order by e.fecha desc")
    List<ExamenesMedicos> listarPorCita(@Param("idCita") Integer idCita);
}