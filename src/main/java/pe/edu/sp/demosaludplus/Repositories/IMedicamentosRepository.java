package pe.edu.sp.demosaludplus.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.Medicamentos;

import java.util.List;

public interface IMedicamentosRepository extends JpaRepository<Medicamentos, Integer> {

    //buscar medicamento por nombre
    @Query(value = "SELECT * FROM medicamentos m WHERE m.nombre = :nombre", nativeQuery = true)
    public List<Medicamentos> buscarPorNombre(@Param("nombre") String nombre);

    //buscar pos la dosis y que te de los medicamentos con esa dosis
    @Query(value = "SELECT * FROM medicamentos m WHERE m.dosis = :dosis", nativeQuery = true)
    public List<Medicamentos> buscarPorDosis(@Param("dosis") String dosis);

    //buscar por duracion y que de la cantdidad de medicamentos
    @Query(value = "SELECT m.duracion, COUNT(*) AS cantidad " +
            "FROM medicamentos m " +
            "GROUP BY m.duracion", nativeQuery = true)
    public List<Object[]> contarMedicamentosPorDuracion();




}
