package pe.edu.sp.demosaludplus.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.CitasMedicas;

import java.util.List;

public interface ICitasMedicasRepository extends CrudRepository<CitasMedicas, Integer> {
    //este query mostrara todas las citas medicas activas
    @Query(value = "select * from citas_medicas c where c.estado = 'ACTIVA'", nativeQuery = true)
    public List<CitasMedicas> obtenerCitasMedicasActivas();

    //muestra la cantidad de citas por el estado
    @Query(value = "select c.estado, count(*) from citas_medicas c group by c.estado", nativeQuery = true)
    public List<Object[]> cantidadCitasPresencialesPorEstado();

    //este query busca la cita medica por el id_usuario
    @Query(value = "select * from citas_medicas c where c.id_usuario = :idUsuario", nativeQuery = true)
    public List<CitasMedicas> buscarCitasPorIdUsuario(@Param("id_usuario") Integer idUsuario);


    //este query al poner la fecha sale la cantidad de usuarios que tienen cita para ese día
    @Query(value = "select c.fecha_cita, count(distinct c.id_usuario) " +
            "from citas_medicas c " +
            "where c.fecha_cita = :fecha_cita " +
            "group by c.fecha_cita", nativeQuery = true)
    public List<Object[]> cantidadUsuariosConCitaEnFecha(@Param("fecha_cita") java.time.LocalDate fecha_cita);
}
