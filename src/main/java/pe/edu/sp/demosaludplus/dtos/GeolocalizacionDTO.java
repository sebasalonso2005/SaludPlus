package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDateTime;

public class GeolocalizacionDTO {
    private Integer idGeolocalizacion;
    private Double latitud;
    private Double longitud;
    private LocalDateTime fecha;

    public Integer getIdGeolocalizacion() {
        return idGeolocalizacion;}

    public void setIdGeolocalizacion(Integer idGeolocalizacion) {this.idGeolocalizacion = idGeolocalizacion;}

    public Double getLatitud() {return latitud;}

    public void setLatitud(Double latitud) {this.latitud = latitud;}

    public Double getLongitud() {return longitud;}

    public void setLongitud(Double longitud) {this.longitud = longitud;}

    public LocalDateTime getFecha() {return fecha;}

    public void setFecha(LocalDateTime fecha) {this.fecha = fecha;}
}
