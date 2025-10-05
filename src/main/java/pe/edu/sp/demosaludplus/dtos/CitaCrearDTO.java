package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CitaCrearDTO {
    private LocalDate fechaCita;
    private LocalDateTime hora;
    private String tipo;
    private String estado;
    private String motivo;
    private Integer duracionMin;
    private Integer idUsuario;

    public CitaCrearDTO() {}

    public CitaCrearDTO(LocalDate fechaCita, LocalDateTime hora, String tipo, String estado, String motivo, Integer duracionMin, Integer idUsuario) {
        this.fechaCita = fechaCita;
        this.hora = hora;
        this.tipo = tipo;
        this.estado = estado;
        this.motivo = motivo;
        this.duracionMin = duracionMin;
        this.idUsuario = idUsuario;
    }

    public LocalDate getFechaCita() { return fechaCita; }
    public void setFechaCita(LocalDate fechaCita) { this.fechaCita = fechaCita; }
    public LocalDateTime getHora() { return hora; }
    public void setHora(LocalDateTime hora) { this.hora = hora; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public Integer getDuracionMin() { return duracionMin; }
    public void setDuracionMin(Integer duracionMin) { this.duracionMin = duracionMin; }
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
}
