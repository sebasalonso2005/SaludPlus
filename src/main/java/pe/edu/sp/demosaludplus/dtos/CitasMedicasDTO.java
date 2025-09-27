package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CitasMedicasDTO {

    private Integer id_cita;
    private LocalDate fecha_cita;
    private LocalDateTime hora;
    private String tipo;
    private String estado;
    private String motivo;
    private LocalDateTime creadaEn;
    private Integer duracionMin;

    public Integer getId_cita() {return id_cita;}

    public void setId_cita(Integer id_cita) {this.id_cita = id_cita;}

    public LocalDate getFecha_cita() {return fecha_cita;}

    public void setFecha_cita(LocalDate fecha_cita) {this.fecha_cita = fecha_cita;}

    public LocalDateTime getHora() {return hora;}

    public void setHora(LocalDateTime hora) {this.hora = hora;}

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    public String getMotivo() {return motivo;}

    public void setMotivo(String motivo) {this.motivo = motivo;}

    public LocalDateTime getCreadaEn() {return creadaEn;}

    public void setCreadaEn(LocalDateTime creadaEn) {this.creadaEn = creadaEn;}

    public Integer getDuracionMin() {return duracionMin;}

    public void setDuracionMin(Integer duracionMin) {this.duracionMin = duracionMin;}
}
