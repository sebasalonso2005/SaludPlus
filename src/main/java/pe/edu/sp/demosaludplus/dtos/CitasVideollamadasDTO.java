package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDateTime;

public class CitasVideollamadasDTO {
    private Integer id_videollamada;
    private String enlaceUrl;
    private String codigoAcceso;
    private String plataforma;
    private String estado;
    private LocalDateTime programadaEn;
    private LocalDateTime iniciaEn;
    private LocalDateTime finalizaEn;

    public Integer getId_videollamada() {return id_videollamada;}

    public void setId_videollamada(Integer id_videollamada) {this.id_videollamada = id_videollamada;}

    public String getEnlaceUrl() {return enlaceUrl;}

    public void setEnlaceUrl(String enlaceUrl) {this.enlaceUrl = enlaceUrl;}

    public String getCodigoAcceso() {return codigoAcceso;}

    public void setCodigoAcceso(String codigoAcceso) {this.codigoAcceso = codigoAcceso;}

    public String getPlataforma() {return plataforma;}

    public void setPlataforma(String plataforma) {this.plataforma = plataforma;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    public LocalDateTime getProgramadaEn() {return programadaEn;}

    public void setProgramadaEn(LocalDateTime programadaEn) {this.programadaEn = programadaEn;}

    public LocalDateTime getIniciaEn() {return iniciaEn;}

    public void setIniciaEn(LocalDateTime iniciaEn) {this.iniciaEn = iniciaEn;}

    public LocalDateTime getFinalizaEn() {return finalizaEn;}

    public void setFinalizaEn(LocalDateTime finalizaEn) {this.finalizaEn = finalizaEn;}
}
