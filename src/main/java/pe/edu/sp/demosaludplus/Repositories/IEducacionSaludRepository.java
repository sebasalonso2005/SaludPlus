package pe.edu.sp.demosaludplus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.sp.demosaludplus.Entities.EducacionSalud;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface IEducacionSaludRepository extends JpaRepository<EducacionSalud, Integer> {
    //busca por el titulo
    @Query(value = "select * from EducacionSalud e where e.titulo = :titulo", nativeQuery = true)
    public List<EducacionSalud> buscarPorTitulo(@Param("titulo") String titulo);

    //busca por fecha de publicaion y te los muestra
    @Query(value = "select * from educacion_salud e where e.fecha_publicacion = :fechaPublicacion", nativeQuery = true)
    public List<EducacionSalud> buscarPorFechaPublicacion(@Param("fechaPublicacion") LocalDate fechaPublicacion);

    //al poner el tipo salga la cantidad de id registradas con ese tipo
    @Query(value = "select e.tipo, count(e.idEdu) as cantidad " +
            "from educacion_salud e " +
            "where e.tipo = :tipo " +
            "group by e.tipo", nativeQuery = true)
    public List<Object[]> contarPorTipo(@Param("tipo") String tipo);
}
