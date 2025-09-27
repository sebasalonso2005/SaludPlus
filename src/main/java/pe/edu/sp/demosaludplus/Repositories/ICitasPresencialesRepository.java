package pe.edu.sp.demosaludplus.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pe.edu.sp.demosaludplus.Entities.CitasPresenciales;

import java.util.List;

public interface ICitasPresencialesRepository extends CrudRepository<CitasPresenciales, Integer> {
    //muestra el estado de las citas
    @Query(value = "select c.id_presencial, c.estado from citas_presenciales c", nativeQuery = true)
    public List<Object[]> mostrarEstadoDeCitas();

    //muestra la cantidad de citas por el estado
    @Query(value = "select c.estado, count(*) from citas_presenciales c group by c.estado", nativeQuery = true)
    public List<Object[]> cantidadCitasPresencialesPorEstado();

    //este query muesta la cantidad de medicos por consultorio
    @Query(value = "select c.consultorio, count(distinct c.medico_asignado) " +
            "from citas_presenciales c " +
            "group by c.consultorio", nativeQuery = true)
    public List<Object[]> cantidadMedicosPorConsultorio();

    //muestra la cantidad de citas por consultorio
    @Query(value = "select c.consultorio, count(*) " +
            "from citas_presenciales c " +
            "group by c.consultorio", nativeQuery = true)
    public List<Object[]> cantidadCitasPorConsultorio();

    //muestra la cantidad de citas que tiene un medico
    @Query(value = "select c.medico_asignado, count(*) " +
            "from citas_presenciales c " +
            "group by c.medico_asignado", nativeQuery = true)
    public List<Object[]> cantidadCitasPorMedicoAsignado();
}
