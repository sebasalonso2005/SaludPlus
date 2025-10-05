package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDateTime;

public class CitaPresencialDTO {
    private Integer idPresencial;
    private String direccion;
    private String consultorio;
    private String medicoAsignado;
    private String estado;
    private LocalDateTime programadaEn;
    private LocalDateTime iniciaEn;
    private LocalDateTime finalizaEn;

    public CitaPresencialDTO() {}

    public CitaPresencialDTO(Integer idPresencial, String direccion, String consultorio, String medicoAsignado, String estado, LocalDateTime programadaEn, LocalDateTime iniciaEn, LocalDateTime finalizaEn) {
        this.idPresencial = idPresencial;
        this.direccion = direccion;
        this.consultorio = consultorio;
        this.medicoAsignado = medicoAsignado;
        this.estado = estado;
        this.programadaEn = programadaEn;
        this.iniciaEn = iniciaEn;
        this.finalizaEn = finalizaEn;
    }

    public Integer getIdPresencial() { return idPresencial; }
    public void setIdPresencial(Integer idPresencial) { this.idPresencial = idPresencial; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getConsultorio() { return consultorio; }
    public void setConsultorio(String consultorio) { this.consultorio = consultorio; }
    public String getMedicoAsignado() { return medicoAsignado; }
    public void setMedicoAsignado(String medicoAsignado) { this.medicoAsignado = medicoAsignado; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getProgramadaEn() { return programadaEn; }
    public void setProgramadaEn(LocalDateTime programadaEn) { this.programadaEn = programadaEn; }
    public LocalDateTime getIniciaEn() { return iniciaEn; }
    public void setIniciaEn(LocalDateTime iniciaEn) { this.iniciaEn = iniciaEn; }
    public LocalDateTime getFinalizaEn() { return finalizaEn; }
    public void setFinalizaEn(LocalDateTime finalizaEn) { this.finalizaEn = finalizaEn; }
}
