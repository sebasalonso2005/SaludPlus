package pe.edu.sp.demosaludplus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.CitasVideollamadas;

import java.util.List;

public interface ICitasVideollamadasRepository extends JpaRepository<CitasVideollamadas, Integer> {
    //busca por el estado de la cita
    @Query(value = "select * from citas_video_llamadas c where c.estado = :estado", nativeQuery = true)
    public List<CitasVideollamadas> buscarCitasPorEstado(@Param("estado") String estado);
    // el estado de cada cita y en que plataforma esta
    @Query(value = "SELECT c.estado, c.plataforma FROM citas_videollamadas c", nativeQuery = true)
    public List<Object[]> obtenerEstadoYPlataformaDeCitasVideoLlamadas();

    //muestra el estado de las citas
    @Query(value = "select c.id_videollamada, c.estado from citas_presenciales c", nativeQuery = true)
    public List<Object[]> mostrarEstadoDeCitasVideoLlamadas();

    //muestra la cantidad de citas por el estado
    @Query(value = "select c.estado, count(*) from citas_presenciales c group by c.estado", nativeQuery = true)
    public List<Object[]> cantidadCitasVideollamadasPorEstado();
}
