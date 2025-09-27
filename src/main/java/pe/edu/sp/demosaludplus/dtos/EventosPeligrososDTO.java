package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDateTime;

public class EventosPeligrososDTO {
    private Integer idEvento;
    private String tipo;
    private String descripcion;
    private LocalDateTime fecha;

    public Integer getIdEvento() {return idEvento;}

    public void setIdEvento(Integer idEvento) {this.idEvento = idEvento;}

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public LocalDateTime getFecha() {return fecha;}

    public void setFecha(LocalDateTime fecha) {this.fecha = fecha;}
}
