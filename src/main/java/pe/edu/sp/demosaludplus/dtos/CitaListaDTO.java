package pe.edu.upc.demoSaludPlusNuevo.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CitaListaDTO {
    private Integer idCita;
    private LocalDate fechaCita;
    private LocalDateTime hora;
    private String tipo;
    private String estado;
    private Integer duracionMin;

    public CitaListaDTO(Integer idCita, LocalDate fechaCita, LocalDateTime hora, String tipo, String estado, Integer duracionMin) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.hora = hora;
        this.tipo = tipo;
        this.estado = estado;
        this.duracionMin = duracionMin;
    }

    public Integer getIdCita() { return idCita; }
    public void setIdCita(Integer idCita) { this.idCita = idCita; }
    public LocalDate getFechaCita() { return fechaCita; }
    public void setFechaCita(LocalDate fechaCita) { this.fechaCita = fechaCita; }
    public LocalDateTime getHora() { return hora; }
    public void setHora(LocalDateTime hora) { this.hora = hora; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Integer getDuracionMin() { return duracionMin; }
    public void setDuracionMin(Integer duracionMin) { this.duracionMin = duracionMin; }
}
