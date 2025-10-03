package pe.edu.upc.demoSaludPlusNuevo.dtos;

import java.time.LocalDateTime;

public class EventoPeligrosoDTO {
    private Integer idEvento;
    private String tipo;
    private String descripcion;
    private LocalDateTime fecha;
    private Integer idUsuario;

    public EventoPeligrosoDTO(Integer idEvento, String tipo, String descripcion, LocalDateTime fecha, Integer idUsuario) {
        this.idEvento = idEvento;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
    }

    public Integer getIdEvento() { return idEvento; }
    public void setIdEvento(Integer idEvento) { this.idEvento = idEvento; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
}
