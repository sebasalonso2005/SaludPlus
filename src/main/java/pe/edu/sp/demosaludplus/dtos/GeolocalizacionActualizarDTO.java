package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDateTime;

public class GeolocalizacionActualizarDTO {
    private Double latitud;
    private Double longitud;
    private LocalDateTime fecha;

    public GeolocalizacionActualizarDTO() {}

    public GeolocalizacionActualizarDTO(Double latitud, Double longitud, LocalDateTime fecha) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.fecha = fecha;
    }

    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }
    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}
