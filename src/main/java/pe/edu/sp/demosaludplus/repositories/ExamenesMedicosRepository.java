package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.sp.demosaludplus.Entities.ExamenesMedicos;

import java.util.List;

@Repository
public interface ExamenesMedicosRepository extends JpaRepository<ExamenesMedicos, Integer> {

    @Query("select e from ExamenesMedicos e where e.citaMedica.id_cita = :idCita order by e.fecha desc")
    List<ExamenesMedicos> listarPorCita(@Param("idCita") Integer idCita);
}