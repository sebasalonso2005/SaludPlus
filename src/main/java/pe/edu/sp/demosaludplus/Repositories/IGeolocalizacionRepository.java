package pe.edu.sp.demosaludplus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.sp.demosaludplus.Entities.Geolocalizacion;

import java.util.List;

public interface IGeolocalizacionRepository extends JpaRepository<Geolocalizacion, Integer> {

    //buscar registro por tipo
    @Query(value = "SELECT * FROM geolocalizacion g WHERE g.tipo = :tipo", nativeQuery = true)
    public List<Geolocalizacion> buscarPorTipo(@Param("tipo") String tipo);

    //contar registro por fecha
    @Query(value = "SELECT g.fecha, COUNT(*) AS cantidad FROM geolocalizacion g GROUP BY g.fecha ORDER BY g.fecha", nativeQuery = true)
    public List<Object[]> contarPorFecha();

    //busca y genera todos lo registros cuya latitud y longitud esten dentro del rango especificado
    //@Query(value = "SELECT * FROM geolocalizacion g WHERE g.latitud BETWEEN :latMin AND :latMax AND g.longitud BETWEEN :lonMin AND :lonMax", nativeQuery = true)
    //List<Geolocalizacion> buscarPorRangoCoordenadas(@Param("latMin") double latMin,
    //                                                @Param("latMax") double latMax,
    //                                                @Param("lonMin") double lonMin,
    //                                                @Param("lonMax") double lonMax);

    //muestra la cantidad de usuario en la geolocalizacion
    @Query(value = "SELECT COUNT(DISTINCT g.idUsuario) AS cantidad_usuarios FROM geolocalizacion g", nativeQuery = true)
    public int contarUsuariosUnicos();
}

