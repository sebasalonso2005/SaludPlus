package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDateTime;

public class CitaVideollamadaDTO {
    private Integer idVideollamada;
    private String enlaceUrl;
    private String codigoAcceso;
    private String plataforma;
    private String estado;
    private LocalDateTime programadaEn;
    private LocalDateTime iniciaEn;
    private LocalDateTime finalizaEn;

    public CitaVideollamadaDTO() {}

    public CitaVideollamadaDTO(Integer idVideollamada, String enlaceUrl, String codigoAcceso, String plataforma, String estado, LocalDateTime programadaEn, LocalDateTime iniciaEn, LocalDateTime finalizaEn) {
        this.idVideollamada = idVideollamada;
        this.enlaceUrl = enlaceUrl;
        this.codigoAcceso = codigoAcceso;
        this.plataforma = plataforma;
        this.estado = estado;
        this.programadaEn = programadaEn;
        this.iniciaEn = iniciaEn;
        this.finalizaEn = finalizaEn;
    }

    public Integer getIdVideollamada() { return idVideollamada; }
    public void setIdVideollamada(Integer idVideollamada) { this.idVideollamada = idVideollamada; }
    public String getEnlaceUrl() { return enlaceUrl; }
    public void setEnlaceUrl(String enlaceUrl) { this.enlaceUrl = enlaceUrl; }
    public String getCodigoAcceso() { return codigoAcceso; }
    public void setCodigoAcceso(String codigoAcceso) { this.codigoAcceso = codigoAcceso; }
    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getProgramadaEn() { return programadaEn; }
    public void setProgramadaEn(LocalDateTime programadaEn) { this.programadaEn = programadaEn; }
    public LocalDateTime getIniciaEn() { return iniciaEn; }
    public void setIniciaEn(LocalDateTime iniciaEn) { this.iniciaEn = iniciaEn; }
    public LocalDateTime getFinalizaEn() { return finalizaEn; }
    public void setFinalizaEn(LocalDateTime finalizaEn) { this.finalizaEn = finalizaEn; }
}
