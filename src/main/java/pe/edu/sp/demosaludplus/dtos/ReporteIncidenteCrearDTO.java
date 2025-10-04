package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReporteIncidenteCrearDTO {
    private String tipoIncidente;
    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    private String lugarIncidente;

    public ReporteIncidenteCrearDTO(String tipoIncidente, String descripcion, LocalDate fecha, LocalTime hora, String lugarIncidente) {
        this.tipoIncidente = tipoIncidente;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.lugarIncidente = lugarIncidente;
    }

    public String getTipoIncidente() { return tipoIncidente; }
    public void setTipoIncidente(String tipoIncidente) { this.tipoIncidente = tipoIncidente; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public String getLugarIncidente() { return lugarIncidente; }
    public void setLugarIncidente(String lugarIncidente) { this.lugarIncidente = lugarIncidente; }
}
