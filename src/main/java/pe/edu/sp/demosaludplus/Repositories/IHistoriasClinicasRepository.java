package pe.edu.sp.demosaludplus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.HistoriasClinicas;

import java.util.List;

public interface IHistoriasClinicasRepository extends JpaRepository<HistoriasClinicas, Integer> {

    //buscar buscar por enfermedades cornicas y te da la cantidad des historias clinicas
    @Query(value = "SELECT COUNT(*) FROM historias_clinicas h WHERE h.enfermedadesCronicas ILIKE %:enfermedad%", nativeQuery = true)
    public int contarPorEnfermedadCronica(@Param("enfermedad") String enfermedad);


    //buscar historias clinicas por diagnostio
    @Query(value = "SELECT * FROM historias_clinicas h WHERE h.diagnostico ILIKE %:diagnostico%", nativeQuery = true)
    public List<HistoriasClinicas> buscarPorDiagnostico(@Param("diagnostico") String diagnostico);

    //contar historias clinicas por fecha
    @Query(value = "SELECT h.fechaCreacion, COUNT(*) AS cantidad " +
            "FROM historias_clinicas h " +
            "GROUP BY h.fechaCreacion " +
            "ORDER BY h.fechaCreacion", nativeQuery = true)
    public List<Object[]> contarPorFechaCreacion();

}
