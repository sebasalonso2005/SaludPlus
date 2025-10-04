package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CitaDetalleDTO {
    private Integer idCita;
    private LocalDate fechaCita;
    private LocalDateTime hora;
    private String tipo;
    private String estado;
    private String motivo;
    private LocalDateTime creadaEn;
    private Integer duracionMin;
    private Integer idUsuario;
    private CitaPresencialDTO presencial;
    private CitaVideollamadaDTO videollamada;

    public CitaDetalleDTO(Integer idCita, LocalDate fechaCita, LocalDateTime hora, String tipo, String estado, String motivo, LocalDateTime creadaEn, Integer duracionMin, Integer idUsuario, CitaPresencialDTO presencial, CitaVideollamadaDTO videollamada) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.hora = hora;
        this.tipo = tipo;
        this.estado = estado;
        this.motivo = motivo;
        this.creadaEn = creadaEn;
        this.duracionMin = duracionMin;
        this.idUsuario = idUsuario;
        this.presencial = presencial;
        this.videollamada = videollamada;
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
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public LocalDateTime getCreadaEn() { return creadaEn; }
    public void setCreadaEn(LocalDateTime creadaEn) { this.creadaEn = creadaEn; }
    public Integer getDuracionMin() { return duracionMin; }
    public void setDuracionMin(Integer duracionMin) { this.duracionMin = duracionMin; }
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
    public CitaPresencialDTO getPresencial() { return presencial; }
    public void setPresencial(CitaPresencialDTO presencial) { this.presencial = presencial; }
    public CitaVideollamadaDTO getVideollamada() { return videollamada; }
    public void setVideollamada(CitaVideollamadaDTO videollamada) { this.videollamada = videollamada; }
}
