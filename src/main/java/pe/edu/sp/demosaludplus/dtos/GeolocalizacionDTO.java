package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDateTime;

public class GeolocalizacionDTO {
    private Integer idGeolocalizacion;
    private Double latitud;
    private Double longitud;
    private LocalDateTime fecha;
    private Integer idUsuario;

    public GeolocalizacionDTO() {}

    public GeolocalizacionDTO(Integer idGeolocalizacion, Double latitud, Double longitud, LocalDateTime fecha, Integer idUsuario) {
        this.idGeolocalizacion = idGeolocalizacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
    }

    public Integer getIdGeolocalizacion() { return idGeolocalizacion; }
    public void setIdGeolocalizacion(Integer idGeolocalizacion) { this.idGeolocalizacion = idGeolocalizacion; }
    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }
    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
}
