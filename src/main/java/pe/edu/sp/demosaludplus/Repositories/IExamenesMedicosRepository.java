package pe.edu.sp.demosaludplus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.ExamenesMedicos;

import java.time.LocalDate;
import java.util.List;

public interface IExamenesMedicosRepository extends JpaRepository<ExamenesMedicos, Integer> {
    //buscar los examenes por tipo
    @Query(value = "SELECT * FROM ExamenesMedicos e WHERE e.tipoExamen = :tipoExamen", nativeQuery = true)
    public List<ExamenesMedicos> buscarPorTipo(@Param("tipoExamen") String tipoExamen);

    //contar la cantidad de Examenes realizados en un fecha
    @Query(value = "SELECT COUNT(*) FROM ExamenesMedicos e " +
            "WHERE e.fecha = :fecha", nativeQuery = true)
    public List<Object[]> contarPorFecha(@Param("fecha") LocalDate fecha);

    //la cantidad de examenes por tipo
    @Query(value = "SELECT e.tipoExamen, COUNT(*) AS cantidad FROM ExamenesMedicos e GROUP BY e.tipoExamen", nativeQuery = true)
    public List<Object[]> contarExamenesPorTipo();

    //cantidad de examenes por url
    @Query(value = "SELECT e.archivoUrl, COUNT(*) AS cantidad " +
            "FROM ExamenesMedicos e " +
            "GROUP BY e.archivoUrl", nativeQuery = true)
    public List<Object[]> contarExamenesPorArchivoUrl();
}
