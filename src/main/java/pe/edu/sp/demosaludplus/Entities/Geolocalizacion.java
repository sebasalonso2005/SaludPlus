package pe.edu.sp.demosaludplus.Entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "geolocalizacion")
public class Geolocalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_geolocalizacion")
    private Integer idGeolocalizacion;

    // Usa Double o BigDecimal con precision/scale si necesitas más exactitud
    @Column(name = "latitud", nullable = false)
    private Double latitud;

    @Column(name = "longitud", nullable = false)
    private Double longitud;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "id_usuario",
            referencedColumnName = "id_usuario",
            nullable = false,
            unique = true           // Garantiza 1–1 en la base
    )
    private Usuarios usuario;

    public Geolocalizacion() {}

    public Geolocalizacion(Integer idGeolocalizacion, Double latitud, Double longitud, LocalDateTime fecha, Usuarios usuario) {
        this.idGeolocalizacion = idGeolocalizacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Integer getIdGeolocalizacion() {
        return idGeolocalizacion;
    }

    public void setIdGeolocalizacion(Integer idGeolocalizacion) {
        this.idGeolocalizacion = idGeolocalizacion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}



