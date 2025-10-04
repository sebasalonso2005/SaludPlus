package pe.edu.sp.demosaludplus.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "ReportesIncidentes")
public class ReportesIncidentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reporte;

    @Column(name = "tipoIncidente", nullable = false, length = 50)
    private String tipoIncidente;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "lugarIncidente", nullable = false, length = 30)
    private String lugarIncidente;

    public ReportesIncidentes() {
    }

    public ReportesIncidentes(int id_reporte, String tipoIncidente, String descripcion,
                              LocalDate fecha, LocalTime hora, String lugarIncidente) {
        this.id_reporte = id_reporte;
        this.tipoIncidente = tipoIncidente;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.lugarIncidente = lugarIncidente;
    }

    public int getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(int id_reporte) {
        this.id_reporte = id_reporte;
    }

    public String getTipoIncidente() {
        return tipoIncidente;
    }

    public void setTipoIncidente(String tipoIncidente) {
        this.tipoIncidente = tipoIncidente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getLugarIncidente() {
        return lugarIncidente;
    }

    public void setLugarIncidente(String lugarIncidente) {
        this.lugarIncidente = lugarIncidente;
    }
}